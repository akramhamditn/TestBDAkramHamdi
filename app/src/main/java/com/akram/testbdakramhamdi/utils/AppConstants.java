package com.akram.testbdakramhamdi.utils;

/**
 * Created by akram on 19/02/2018.
 */

public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "businessdecision.db";
    public static final String PREF_NAME = "businessdecision_pref";

    public static final long NULL_INDEX = -1L;

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String API_BASE_URL = "https://api.github.com/search/";
    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
