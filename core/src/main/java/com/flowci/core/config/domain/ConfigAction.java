package com.flowci.core.config.domain;

public abstract class ConfigAction {

    public static final String LIST = "list_config";

    public static final String GET = "get_config";

    public static final String SAVE = "create_or_update_config";

    public static final String DELETE = "delete_config";

    public static final String[] ALL = {
            LIST,
            GET,
            SAVE,
            DELETE
    };
}
