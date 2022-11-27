package com.vxg.cloudsdk.streamland_player.snippets;

import android.util.Log;
import android.util.Pair;

import com.vxg.cloud.core.CloudHelpers;
import com.vxg.cloudsdk.CloudPlayerSDK;
import com.vxg.cloudsdk.Interfaces.ICompletionCallback;
import com.vxg.cloudsdk.Objects.CloudEvent;
import com.vxg.cloudsdk.Objects.CloudTimeline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://web.vaplatform.ru/docs/v2.html#/storage%20(data)
// https://web.vaplatform.ru/docs/v2.html#/storage%20(data)/get_storage_events_
public class CloudEvents {
    public final String TAG = CloudEvents.class.getSimpleName();

    private final CloudPlayerSDK playerSDK;

    public CloudEvents(CloudPlayerSDK sdk) {
        this.playerSDK = sdk;
    }

    public void printEvents() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 60 * 60 * 1000;

        playerSDK.getEvents(startTime, endTime, null, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudEvent> events = (ArrayList<CloudEvent>)o_result;
            for (CloudEvent event : events) {
                Log.e(TAG, "event: " + CloudHelpers.objectToString(event));
            }
            return 0;
        });
    }

    public void printEventsSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 60 * 60 * 1000;

        ArrayList<CloudEvent> events = playerSDK.getEventsSync(startTime, endTime, null);
        for (CloudEvent event : events) {
            Log.e(TAG, "event: " + CloudHelpers.objectToString(event));
        }
    }


    public void printEventsWithLimit() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 60 * 60 * 1000;

        playerSDK.getEvents(startTime, endTime, 0, 10, null, false, "", null, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudEvent> events = (ArrayList<CloudEvent>)o_result;
            for (CloudEvent event : events) {
                Log.e(TAG, "event: " + CloudHelpers.objectToString(event));
            }
            return 0;
        });
    }

    public void printEventsWithLimitSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 60 * 60 * 1000;

        ArrayList<String> eventList =  new ArrayList<>(Collections.unmodifiableList(Arrays.asList("motion", "sound")));
        ArrayList<CloudEvent> events = playerSDK.getEventsSync(startTime, endTime, 0, 10, eventList, false, "", null);
        for (CloudEvent event : events) {
            Log.e(TAG, "event: " + CloudHelpers.objectToString(event));
        }
    }
}
