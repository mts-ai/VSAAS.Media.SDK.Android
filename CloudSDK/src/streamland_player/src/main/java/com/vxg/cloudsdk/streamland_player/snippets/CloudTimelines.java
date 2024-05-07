package com.vxg.cloudsdk.streamland_player.snippets;

import android.util.Log;
import android.util.Pair;

import com.vxg.cloud.core.CloudHelpers;
import com.vxg.cloudsdk.CloudPlayerSDK;

import java.util.ArrayList;
import java.util.Collections;

// https://web.vaplatform.ru/docs/v2.html#/storage%20(calendar%20%26%20timeline)
// https://web.vaplatform.ru/docs/v2.html#/storage%20(calendar%20%26%20timeline)/get_storage_timeline__CAMID__
public class CloudTimelines {
    public final String TAG = CloudTimelines.class.getSimpleName();

    private final CloudPlayerSDK playerSDK;

    public CloudTimelines(CloudPlayerSDK sdk) {
        this.playerSDK = sdk;
    }

    public void printTimeline() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 2 * 24 * 60 * 60 * 1000;

        playerSDK.getTimeline(startTime, endTime, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            com.vxg.cloudsdk.Objects.CloudTimeline timeline = (com.vxg.cloudsdk.Objects.CloudTimeline)o_result;
            Log.e(TAG, "timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
            for (Pair<Long, Long> item : timeline.periods) {
                Log.e(TAG, "item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
            }
            return 0;
        });
    }

    public void printTimelineSync() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 2 * 24 * 60 * 60 * 1000;

        com.vxg.cloudsdk.Objects.CloudTimeline timeline = playerSDK.getTimelineSync(startTime, endTime);
        Log.e(TAG, "timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }
    }


    public void printTimelineWithLimit() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 24 * 60 * 60 * 1000;

        Log.e(TAG, "timeline try for: start: " + CloudHelpers.formatTime(startTime) + ", end: " + CloudHelpers.formatTime(endTime));
        playerSDK.getTimeline(startTime, endTime, 0, 10, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            com.vxg.cloudsdk.Objects.CloudTimeline timeline = (com.vxg.cloudsdk.Objects.CloudTimeline)o_result;
            Log.e(TAG, "timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
            for (Pair<Long, Long> item : timeline.periods) {
                Log.e(TAG, "item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
            }
            return 0;
        });
    }

    public void printTimelineWithLimitSync() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 24 * 60 * 60 * 1000;

        com.vxg.cloudsdk.Objects.CloudTimeline timeline = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
        Log.e(TAG, "timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }
    }

    public void printTimelineWithLimitAndPagingSync() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 10 * 24 * 60 * 60 * 1000;

        int count = 10;
        int offset = 0;
        int limit = 3;

        com.vxg.cloudsdk.Objects.CloudTimeline timeline = playerSDK.getTimelineSync(startTime, endTime, 0, limit * count, false, null, null);
        Log.e(TAG, "reference: timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "reference: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }

        for (int i = 0; i < count; i++) {
            timeline = playerSDK.getTimelineSync(startTime, endTime, offset, limit, false, null, null);
            Log.e(TAG, "page: timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
            for (Pair<Long, Long> item : timeline.periods) {
                Log.e(TAG, "page: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
            }
            if (timeline.periods.size() < limit) {
                break;
            }
            offset += limit;
        }

    }

}
