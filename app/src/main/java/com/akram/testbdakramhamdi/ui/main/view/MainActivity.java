package com.akram.testbdakramhamdi.ui.main.view;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.akram.testbdakramhamdi.R;
import com.akram.testbdakramhamdi.data.backend.GitHubClient;
import com.akram.testbdakramhamdi.data.backend.ServiceGenerator;
import com.akram.testbdakramhamdi.data.model.GitHubRepositorie;
import com.akram.testbdakramhamdi.ui.base.BaseActivity;
import com.akram.testbdakramhamdi.ui.base.BasePresenter;
import com.akram.testbdakramhamdi.ui.main.model.MainResponse;
import com.akram.testbdakramhamdi.ui.main.presenter.MainPresenter;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

public class MainActivity extends BaseActivity<BasePresenter> implements MainActivityView{

    Button searchBtn;
    TextView responseText;
    EditText editText;
    ProgressBar progressBar;
    GitHubClient gitHubClient;

    @NonNull
    @Override
    protected BasePresenter createPresenter(@NonNull Context context) {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a very simple REST adapter which points the GitHub API endpoint.
        gitHubClient = ServiceGenerator.createService(GitHubClient.class);

        searchBtn       = (Button)      findViewById(R.id.main_btn_lookup);
        responseText    = (TextView)    findViewById(R.id.main_text_response);
        editText        = (EditText)    findViewById(R.id.main_edit_username);
        progressBar     = (ProgressBar) findViewById(R.id.main_progress);
        progressBar.setVisibility(View.INVISIBLE);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchForRepositorie();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchForRepositorie();
                }
                return handled;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void searchForRepositorie() {
        String user = editText.getText().toString();
        progressBar.setVisibility(View.VISIBLE);


        final Call<GitHubRepositorie> call = gitHubClient.getFeed(user);
        call.enqueue(new Callback<GitHubRepositorie>() {
            @Override
            public void onResponse(Response<GitHubRepositorie> response) {
                //Display successful response results
                GitHubRepositorie gitModel = response.body();
                if (gitModel != null) {
                    responseText.setText(getString(R.string.main_response_text,
                            gitModel.getName(),
                            gitModel.getDescription(),
                            gitModel.getNbStars()));
                } else {
                    responseText.setText("");
                    new MainResponse(true);
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.main_error_text),
                            Toast.LENGTH_SHORT).show();

                }
                //Hide progressbar when done
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Throwable t) {
                // Display error message if the request fails
                responseText.setText(""); //Error needs to be handled properly
                //Hide progressbar when done
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
