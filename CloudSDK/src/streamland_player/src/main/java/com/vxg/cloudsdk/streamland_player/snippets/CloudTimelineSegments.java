package com.vxg.cloudsdk.streamland_player.snippets;

import android.util.Log;
import android.util.Pair;

import com.vxg.cloud.core.CloudHelpers;
import com.vxg.cloudsdk.CloudPlayerSDK;
import com.vxg.cloudsdk.Objects.CloudEvent;
import com.vxg.cloudsdk.Objects.CloudTimeline;
import com.vxg.cloudsdk.Objects.CloudTimelineSegment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://web.vaplatform.ru/docs/v2.html#/storage%20(data)
// https://web.vaplatform.ru/docs/v2.html#/storage%20(data)/get_storage_data_
public class CloudTimelineSegments {
    public final String TAG = CloudTimelineSegments.class.getSimpleName();

    private final CloudPlayerSDK playerSDK;

    public CloudTimelineSegments(CloudPlayerSDK sdk) {
        this.playerSDK = sdk;
    }

    public void printSegments() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        playerSDK.getTimelineSegments(startTime, endTime, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudTimelineSegment> segments = (ArrayList<CloudTimelineSegment>)o_result;
            for (CloudTimelineSegment segment : segments) {
                Log.e(TAG, "segment: " + CloudHelpers.objectToString(segment));
            }
            return 0;
        });
    }

    public void printSegmentsSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        ArrayList<CloudTimelineSegment> segments = playerSDK.getTimelineSegmentsSync(startTime, endTime);
        for (CloudTimelineSegment segment : segments) {
            Log.e(TAG, "segment: " + CloudHelpers.objectToString(segment));
        }
    }


    public void printSegmentsWithLimit() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 60 * 60 * 1000;

        playerSDK.getTimelineSegments(startTime, endTime, 0, 10,false, "", null, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudTimelineSegment> segments = (ArrayList<CloudTimelineSegment>)o_result;
            for (CloudTimelineSegment segment : segments) {
                Log.e(TAG, "segment: " + CloudHelpers.objectToString(segment));
            }
            return 0;
        });
    }

    public void printSegmentsWithLimitSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 60 * 60 * 1000;

        ArrayList<CloudTimelineSegment> segments = playerSDK.getTimelineSegmentsSync(startTime, endTime, 0, 10,false, "", true);
        for (CloudTimelineSegment segment : segments) {
            Log.e(TAG, "segment: " + CloudHelpers.objectToString(segment));
        }
    }

    public void printSegment() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        playerSDK.getTimelineSegments(startTime, endTime, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudTimelineSegment> segments = (ArrayList<CloudTimelineSegment>)o_result;
            for (CloudTimelineSegment segment : segments) {
                playerSDK.getTimelineSegment(segment.id, (o_result1, result1) -> {
                    if (result1 != 0) {
                        return 0;
                    }

                    CloudTimelineSegment it = (CloudTimelineSegment)o_result1;
                    Log.e(TAG, "segment: " + CloudHelpers.objectToString(it));
                    return 0;
                });
                break;
            }
            return 0;
        });
    }

    public void printSegmentSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        playerSDK.getTimelineSegments(startTime, endTime, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudTimelineSegment> segments = (ArrayList<CloudTimelineSegment>)o_result;
            for (CloudTimelineSegment segment : segments) {
                CloudTimelineSegment it = playerSDK.getTimelineSegmentSync(segment.id);
                Log.e(TAG, "segment: " + CloudHelpers.objectToString(it));
                break;
            }
            return 0;
        });
    }

    public void deleteSegmentForTime() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        CloudTimeline timeline = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
        Log.e(TAG, "before: timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "before: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }

        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "delete: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));

            playerSDK.deleteTimelineSegments(item.first, item.second, (o_result, result) -> {
                Log.e(TAG, "delete segment: " + result);

                CloudTimeline timeline1 = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
                Log.e(TAG, "after: timeline: start: " + CloudHelpers.formatTime(timeline1.start) + ", end: " + CloudHelpers.formatTime(timeline1.end) + ", periods: " + timeline1.periods.size());
                for (Pair<Long, Long> item1 : timeline1.periods) {
                    Log.e(TAG, "after: item: start: " + CloudHelpers.formatTime(item1.first) + ", end: " + CloudHelpers.formatTime(item1.second));
                }
                return 0;
            });
            break;
        }
    }

    public void deleteSegmentForTimeSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        com.vxg.cloudsdk.Objects.CloudTimeline timeline = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
        Log.e(TAG, "before: timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "before: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }

        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "delete: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));

            int ret = playerSDK.deleteTimelineSegmentsSync(item.first, item.second);
            Log.e(TAG, "delete segment: " + ret);
            break;
        }

        timeline = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
        Log.e(TAG, "after: timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "after: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }
    }

    public void deleteSegmentForRecordId() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        com.vxg.cloudsdk.Objects.CloudTimeline timeline = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
        Log.e(TAG, "before: timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "before: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }

        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "delete: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));

            ArrayList<CloudTimelineSegment> segments = playerSDK.getTimelineSegmentsSync(item.first, item.second);
            for (CloudTimelineSegment segment : segments) {
                Log.e(TAG, "first segment: " + CloudHelpers.objectToString(segment));

                playerSDK.deleteTimelineSegment(segment.id, (o_result, result) -> {
                    Log.e(TAG, "delete segment: " + result);

                    CloudTimeline timeline1 = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
                    Log.e(TAG, "after: timeline: start: " + CloudHelpers.formatTime(timeline1.start) + ", end: " + CloudHelpers.formatTime(timeline1.end) + ", periods: " + timeline1.periods.size());
                    for (Pair<Long, Long> item1 : timeline1.periods) {
                        Log.e(TAG, "after: item: start: " + CloudHelpers.formatTime(item1.first) + ", end: " + CloudHelpers.formatTime(item1.second));
                    }
                    return 0;
                });
                break;
            }
            break;
        }
    }

    public void deleteSegmentForRecordIdSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        com.vxg.cloudsdk.Objects.CloudTimeline timeline = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
        Log.e(TAG, "before: timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "before: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }

        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "delete: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));

            ArrayList<CloudTimelineSegment> segments = playerSDK.getTimelineSegmentsSync(item.first, item.second);
            for (CloudTimelineSegment segment : segments) {
                Log.e(TAG, "first segment: " + CloudHelpers.objectToString(segment));
                int ret = playerSDK.deleteTimelineSegmentSync(segment.id);
                Log.e(TAG, "delete segment: " + ret);
                break;
            }
            break;
        }

        timeline = playerSDK.getTimelineSync(startTime, endTime, 0, 10);
        Log.e(TAG, "after: timeline: start: " + CloudHelpers.formatTime(timeline.start) + ", end: " + CloudHelpers.formatTime(timeline.end) + ", periods: " + timeline.periods.size());
        for (Pair<Long, Long> item : timeline.periods) {
            Log.e(TAG, "after: item: start: " + CloudHelpers.formatTime(item.first) + ", end: " + CloudHelpers.formatTime(item.second));
        }
    }

}
