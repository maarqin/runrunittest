package com.thomazmarcos.runrunittest.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by thomaz on 17/03/2018.
 */
public class Task extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("uid")
    @Expose
    private Long uid;

    @SerializedName("_permission_")
    @Expose
    private Boolean _permission_;

    @SerializedName("estimated_start_date")
    @Expose
    private Date estimated_start_date;

    @SerializedName("desired_date")
    @Expose
    private Date desired_date;

    @SerializedName("checklist_id")
    @Expose
    private Long checklist_id;

    @SerializedName("type_color")
    @Expose
    private String type_color;

    @SerializedName("last_estimated_at")
    @Expose
    private Date last_estimated_at;

    @SerializedName("approved")
    @Expose
    private String approved;

    @SerializedName("was_reopened")
    @Expose
    private Boolean was_reopened;

    @SerializedName("priority")
    @Expose
    private Integer priority;

    @SerializedName("workflow_id")
    @Expose
    private Long workflow_id;

    @SerializedName("evaluation_status")
    @Expose
    private String evaluation_status;

    @SerializedName("estimated_delivery_date_updated")
    @Expose
    private Boolean estimated_delivery_date_updated;

    @SerializedName("activities")
    @Expose
    private String activities;

    @SerializedName("repetition_rule_id")
    @Expose
    private Long repetition_rule_id;

    @SerializedName("activities_2_days_ago")
    @Expose
    private Integer activities_2_days_ago;

    @SerializedName("activities_5_days_ago")
    @Expose
    private Integer activities_5_days_ago;

    @SerializedName("is_closed")
    @Expose
    private Boolean is_closed;

    @SerializedName("responsible_name")
    @Expose
    private String responsible_name;

    @SerializedName("task_status_name")
    @Expose
    private String task_status_name;

    @SerializedName("user_name")
    @Expose
    private String user_name;

    @SerializedName("activities_4_days_ago")
    @Expose
    private Integer activities_4_days_ago;

    @SerializedName("tag_list")
    @Expose
    private String tag_list;

    @SerializedName("task_status_id")
    @Expose
    private Long task_status_id;

    @SerializedName("time_total")
    @Expose
    private Long time_total;

    @SerializedName("project_id")
    @Expose
    private Long project_id;

    @SerializedName("type_name")
    @Expose
    private String type_name;

    @SerializedName("activities_3_days_ago")
    @Expose
    private Integer activities_3_days_ago;

    @SerializedName("team_id")
    @Expose
    private Long team_id;

    @SerializedName("task_state_name")
    @Expose
    private String task_state_name;

    @SerializedName("responsible_id")
    @Expose
    private String responsible_id;

    @SerializedName("desired_date_with_time")
    @Expose
    private Date desired_date_with_time;

    @SerializedName("on_going")
    @Expose
    private Boolean on_going;

    @SerializedName("project_name")
    @Expose
    private String project_name;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("close_date")
    @Expose
    private Date close_date;

    @SerializedName("estimated_delivery_date")
    @Expose
    private Date estimated_delivery_date;

    @SerializedName("task_tags")
    @Expose
    private RealmList<String> task_tags;

    @SerializedName("activities_6_days_ago")
    @Expose
    private Integer activities_6_days_ago;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("current_worked_time")
    @Expose
    private Integer current_worked_time;

    @SerializedName("overdue")
    @Expose
    private String overdue;

    @SerializedName("current_estimate_seconds")
    @Expose
    private Long current_estimate_seconds;

    @SerializedName("is_working_on")
    @Expose
    private Boolean is_working_on;

    @SerializedName("created_at")
    @Expose
    private Date created_at;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("activities_7_days_ago")
    @Expose
    private Integer activities_7_days_ago;

    @SerializedName("client_name")
    @Expose
    private String client_name;

    @SerializedName("queue_position")
    @Expose
    private String queue_position;

    @SerializedName("time_pending")
    @Expose
    private Long time_pending;

    @SerializedName("task_state_id")
    @Expose
    private Long task_state_id;

    @SerializedName("team_name")
    @Expose
    private String team_name;

    @SerializedName("follower_ids")
    @Expose
    private RealmList<String> follower_ids;

    @SerializedName("type_id")
    @Expose
    private Long type_id;

    @SerializedName("time_progress")
    @Expose
    private Double time_progress;

    @SerializedName("scheduled_start_time")
    @Expose
    private Date scheduled_start_time;

    @SerializedName("attachments_count")
    @Expose
    private Integer attachments_count;

    @SerializedName("activities_1_days_ago")
    @Expose
    private Integer activities_1_days_ago;

    @SerializedName("current_evaluator_id")
    @Expose
    private Long current_evaluator_id;

    @SerializedName("is_scheduled")
    @Expose
    private Boolean is_scheduled;

    @SerializedName("time_worked")
    @Expose
    private Long time_worked;

    @SerializedName("start_date")
    @Expose
    private Date start_date;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean IsWorkingOn() {
        return is_working_on;
    }

    public Boolean isClosed() {
        return state.equals("closed");
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIs_working_on(Boolean is_working_on) {
        this.is_working_on = is_working_on;
    }


}