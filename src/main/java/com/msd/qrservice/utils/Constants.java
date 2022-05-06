package com.msd.qrservice.utils;

public class Constants {

    public static final int USER_REST_MODE = 1;
    public static final int USER_VERIFIED_MODE = 2;

    //OTP Types
    public static final int REGISTRATION_VERIFY_OTP = 0;
    public static final int PASSWORD_RESET_VERIFY_OTP = 1;
    public static final int ADMIN_LOGIN_OTP = 3;

    public class USER_TYPE {
        public static final int SUPER_ADMIN = 1;
        public static final int ADMIN = 2;
        public static final int TEACHER = 3;
        public static final int STUDENT = 4;
    }

    public class PAYHERE {
        public static final String MERCHANT_ID = "merchant_id";
        public static final String ORDER_ID = "order_id";
        public static final String PAYMENT_ID = "payment_id";
        public static final String PAYHERE_AMOUNT = "payhere_amount";
        public static final String PAYHERE_CURRENCY = "payhere_currency";
        public static final String MD5SIG = "md5sig";
        public static final String CUSTOM_1 = "custom_1";
        public static final String CUSTOM_2 = "custom_2";
        public static final String METHOD = "method";
        public static final String STATUS_MESSAGE = "status_message";
        public static final String CARD_HOLDER_NAME = "card_holder_name";
        public static final String CARD_NO = "card_no";
        public static final String CARD_EXPIRY = "card_expiry";
        public static final String STATUS_CODE = "status_code";
    }

    public class SAMPATH {
        public static final String CLIENT_REF = "clientRef";
        public static final String COMMENT = "comment";
        public static final String CARD_TYPE = "cardType";
        public static final String CARD_HOLDER_NAME = "cardHolderName";
        public static final String CARD_NUMBER = "cardNumber";
        public static final String CARD_EXPIRY = "cardExpiry";
        public static final String PAYMENT_AMOUNT = "paymentAmount";
        public static final String CURRENCY = "currency";
        public static final String TXN_REFERENCE = "txnReference";
        public static final String RESPONSE_CODE = "responseCode";
        public static final String RESPONSE_TEXT = "responseText";
        public static final String TOKEN = "token";
        public static final String TOKEN_RESPONSE_TEXT = "tokenResponseText";

    }

    public class Zoom {
        public static final String BASE_URL = "https://api.zoom.us/v2/";
        public static final String MEETINGS = "meetings/";
        public static final String RECORDINGS = "recordings/";
        public static final String RECORDING_ID = "id";
        public static final String RECORDING_START = "recording_start";
        public static final String RECORDING_PLAY_URL = "play_url";
        public static final String RECORDING_TOPIC = "topic";
        public static final String RECORDING_FILES = "recording_files";
        public static final String RECORDING_FILE_TYPE = "file_type";
        public static final String RECORDING_FILE_MP4 = "MP4";

    }

}
