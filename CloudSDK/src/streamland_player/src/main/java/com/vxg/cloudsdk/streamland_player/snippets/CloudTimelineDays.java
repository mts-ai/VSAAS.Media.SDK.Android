package com.vxg.cloudsdk.streamland_player.snippets;

import android.util.Log;

import com.vxg.cloud.core.CloudHelpers;
import com.vxg.cloudsdk.CloudPlayerSDK;
import com.vxg.cloudsdk.Interfaces.ICompletionCallback;

import java.util.ArrayList;

// https://web.vaplatform.ru/docs/v2.html#/storage%20(calendar%20%26%20timeline)
// https://web.vaplatform.ru/docs/v2.html#/storage%20(calendar%20%26%20timeline)/get_storage_activity_
public class CloudTimelineDays {
    public final String TAG = CloudTimelineDays.class.getSimpleName();

    private final CloudPlayerSDK playerSDK;

    public CloudTimelineDays(CloudPlayerSDK sdk) {
        this.playerSDK = sdk;
    }

    public void printTimelineDays() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 2 * 24 * 60 * 60 * 1000;

        playerSDK.getTimelineDays(false, (ICompletionCallback) (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<Long> days = (ArrayList<Long>)o_result;
            for (Long day : days) {
                Log.e(TAG, "item: " + CloudHelpers.formatTime(day));
            }
            return 0;
        });
    }

    public void printTimelineDaysSync() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 2 * 24 * 60 * 60 * 1000;

        ArrayList<Long> days = playerSDK.getTimelineDaysSync(false);
        for (Long day : days) {
            Log.e(TAG, "item: " + CloudHelpers.formatTime(day));
        }
    }


    public void printTimelineDaysWithLimit() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 24 * 60 * 60 * 1000;

        playerSDK.getTimelineDays(startTime, endTime, 0, 10, null, false, false, (ICompletionCallback) (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<Long> days = (ArrayList<Long>)o_result;
            for (Long day : days) {
                Log.e(TAG, "item: " + CloudHelpers.formatTime(day));
            }
            return 0;
        });
    }

    public void printTimelineDaysWithLimitSync() {
        // print timeline
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 2 * 24 * 60 * 60 * 1000;

        ArrayList<Long> days = playerSDK.getTimelineDaysSync(startTime, endTime, 0, 10, null, false, false);
        for (Long day : days) {
            Log.e(TAG, "item: " + CloudHelpers.formatTime(day));
        }
    }

}
