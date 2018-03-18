package com.thomazmarcos.runrunittest.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by thomaz on 17/03/2018.
 */
public class Task {

    @SerializedName("uid")
    private Long uid;

    @SerializedName("_permission_")
    private Boolean _permission_;

    @SerializedName("estimated_start_date")
    private Date estimated_start_date;

    @SerializedName("desired_date")
    private Date desired_date;

    @SerializedName("checklist_id")
    private Long checklist_id;

    @SerializedName("type_color")
    private String type_color;

    @SerializedName("last_estimated_at")
    private Date last_estimated_at;

    @SerializedName("approved")
    private Object approved;

    @SerializedName("was_reopened")
    private Boolean was_reopened;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("workflow_id")
    private Long workflow_id;

    @SerializedName("evaluation_status")
    private Object evaluation_status;

    @SerializedName("estimated_delivery_date_updated")
    private Boolean estimated_delivery_date_updated;

    @SerializedName("activities")
    private String activities;

    @SerializedName("repetition_rule_id")
    private Long repetition_rule_id;

    @SerializedName("activities_2_days_ago")
    private Integer activities_2_days_ago;

    @SerializedName("activities_5_days_ago")
    private Integer activities_5_days_ago;

    @SerializedName("is_closed")
    private Boolean is_closed;

    @SerializedName("responsible_name")
    private String responsible_name;

    @SerializedName("task_status_name")
    private Object task_status_name;

    @SerializedName("user_name")
    private String user_name;

    @SerializedName("activities_4_days_ago")
    private Integer activities_4_days_ago;

    @SerializedName("tag_list")
    private String tag_list;

    @SerializedName("task_status_id")
    private Long task_status_id;

    @SerializedName("time_total")
    private Long time_total;

    @SerializedName("project_id")
    private Long project_id;

    @SerializedName("type_name")
    private String type_name;

    @SerializedName("activities_3_days_ago")
    private Integer activities_3_days_ago;

    @SerializedName("team_id")
    private Long team_id;

    @SerializedName("task_state_name")
    private Object task_state_name;

    @SerializedName("responsible_id")
    private String responsible_id;

    @SerializedName("desired_date_with_time")
    private Date desired_date_with_time;

    @SerializedName("on_going")
    private Boolean on_going;

    @SerializedName("project_name")
    private String project_name;

    @SerializedName("state")
    private String state;

    @SerializedName("close_date")
    private Date close_date;

    @SerializedName("estimated_delivery_date")
    private Date estimated_delivery_date;

    @SerializedName("task_tags")
    private List<String> task_tags;

    @SerializedName("id")
    private Long id;

    @SerializedName("activities_6_days_ago")
    private Integer activities_6_days_ago;

    @SerializedName("title")
    private String title;

    @SerializedName("current_worked_time")
    private Integer current_worked_time;

    @SerializedName("overdue")
    private String overdue;

    @SerializedName("current_estimate_seconds")
    private Long current_estimate_seconds;

    @SerializedName("is_working_on")
    private Boolean is_working_on;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("activities_7_days_ago")
    private Integer activities_7_days_ago;

    @SerializedName("client_name")
    private String client_name;

    @SerializedName("queue_position")
    private Object queue_position;

    @SerializedName("time_pending")
    private Long time_pending;

    @SerializedName("task_state_id")
    private Long task_state_id;

    @SerializedName("team_name")
    private Object team_name;

    @SerializedName("follower_ids")
    private List<Object> follower_ids;

    @SerializedName("type_id")
    private Long type_id;

    @SerializedName("time_progress")
    private Double time_progress;

    @SerializedName("scheduled_start_time")
    private Date scheduled_start_time;

    @SerializedName("attachments_count")
    private Integer attachments_count;

    @SerializedName("activities_1_days_ago")
    private Integer activities_1_days_ago;

    @SerializedName("current_evaluator_id")
    private Long current_evaluator_id;

    @SerializedName("is_scheduled")
    private Boolean is_scheduled;

    @SerializedName("time_worked")
    private Long time_worked;

    @SerializedName("start_date")
    private Date start_date;

}