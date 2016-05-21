package com.anonymint;

import io.swagger.annotations.ApiModelProperty;

/**
 * Data Model object decorated with Swagger API Model Property
 *
 * @author <a href="mailto:mint.com@gmail.com">anonymint</a>
 * @since 2016-05-21
 */
class Data {

    private long id;
    private String action;
    private String description;

    public Data() {
    }

    Data(long id, String action) {
        this.id = id;
        this.action = action;
        this.description = String.format("You %s data with given %d id", action, id);
    }

    @ApiModelProperty(notes = "Data", required = true)
    public long getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
