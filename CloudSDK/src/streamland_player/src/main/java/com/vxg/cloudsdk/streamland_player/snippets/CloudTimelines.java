package com.vxg.cloudsdk.streamland_player.snippets;

import android.util.Log;
import android.util.Pair;

import com.vxg.cloud.core.CloudHelpers;
import com.vxg.cloudsdk.CloudPlayerSDK;

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

}
