package com.javaedge.ad.mysql.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sss
 * @date 2019-02-25
 */
public class Constant {

    private static final String DB_NAME = "javaedge_ad_data";

    public static class AD_PLAN_TABLE_INFO {

        public static final String TABLE_NAME = "ad_plan";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_PLAN_STATUS = "plan_status";
        public static final String COLUMN_START_DATE = "start_date";
        public static final String COLUMN_END_DATE = "end_date";
    }

    public static class AD_CREATIVE_TABLE_INFO {

        public static final String TABLE_NAME = "ad_creative";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_MATERIAL_TYPE = "material_type";
        public static final String COLUMN_HEIGHT = "height";
        public static final String COLUMN_WIDTH = "width";
        public static final String COLUMN_AUDIT_STATUS = "audit_status";
        public static final String COLUMN_URL = "url";
    }

    public static class AD_UNIT_TABLE_INFO {

        public static final String TABLE_NAME = "ad_unit";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_UNIT_STATUS = "unit_status";
        public static final String COLUMN_POSITION_TYPE = "position_type";
        public static final String COLUMN_PLAN_ID = "plan_id";
    }

    public static class AD_CREATIVE_UNIT_TABLE_INFO {

        public static final String TABLE_NAME = "creative_unit";

        public static final String COLUMN_CREATIVE_ID = "creative_id";
        public static final String COLUMN_UNIT_ID = "unit_id";
    }

    public static class AD_UNIT_DISTRICT_TABLE_INFO {

        public static final String TABLE_NAME = "ad_unit_district";

        public static final String COLUMN_UNIT_ID = "unit_id";
        public static final String COLUMN_PROVINCE = "province";
        public static final String COLUMN_CITY = "city";
    }

    public static class AD_UNIT_IT_TABLE_INFO {

        public static final String TABLE_NAME = "ad_unit_it";

        public static final String COLUMN_UNIT_ID = "unit_id";
        public static final String COLUMN_IT_TAG = "it_tag";
    }

    public static class AD_UNIT_KEYWORD_TABLE_INFO {

        public static final String TABLE_NAME = "ad_unit_keyword";

        public static final String COLUMN_UNIT_ID = "unit_id";
        public static final String COLUMN_KEYWORD = "keyword";
    }

    public static Map<String, String> table2Db;

    static {

        table2Db = new HashMap<>();

        table2Db.put(AD_PLAN_TABLE_INFO.TABLE_NAME, DB_NAME);
        table2Db.put(AD_CREATIVE_TABLE_INFO.TABLE_NAME, DB_NAME);
        table2Db.put(AD_UNIT_TABLE_INFO.TABLE_NAME, DB_NAME);
        table2Db.put(AD_CREATIVE_UNIT_TABLE_INFO.TABLE_NAME, DB_NAME);
        table2Db.put(AD_UNIT_DISTRICT_TABLE_INFO.TABLE_NAME, DB_NAME);
        table2Db.put(AD_UNIT_IT_TABLE_INFO.TABLE_NAME, DB_NAME);
        table2Db.put(AD_UNIT_KEYWORD_TABLE_INFO.TABLE_NAME, DB_NAME);
    }
}
