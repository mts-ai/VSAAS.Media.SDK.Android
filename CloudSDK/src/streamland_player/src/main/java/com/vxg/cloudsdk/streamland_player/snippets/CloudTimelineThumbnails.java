package com.vxg.cloudsdk.streamland_player.snippets;

import android.util.Log;

import com.vxg.cloud.core.CloudHelpers;
import com.vxg.cloudsdk.CloudPlayerSDK;
import com.vxg.cloudsdk.Objects.CloudTimelineSegment;
import com.vxg.cloudsdk.Objects.CloudTimelineThumbnail;

import java.util.ArrayList;

// https://web.vaplatform.ru/docs/v2.html#/storage%20(data)
// https://web.vaplatform.ru/docs/v2.html#/storage%20(data)/get_storage_data_
public class CloudTimelineThumbnails {
    public final String TAG = CloudTimelineThumbnails.class.getSimpleName();

    private final CloudPlayerSDK playerSDK;

    public CloudTimelineThumbnails(CloudPlayerSDK sdk) {
        this.playerSDK = sdk;
    }

    public void printThumbnails() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        playerSDK.getTimelineThumbnails(startTime, endTime, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudTimelineThumbnail> thumbnails = (ArrayList<CloudTimelineThumbnail>)o_result;
            for (CloudTimelineThumbnail thumbnail : thumbnails) {
                Log.e(TAG, "thumbnail: " + CloudHelpers.objectToString(thumbnail));
            }
            return 0;
        });
    }

    public void printThumbnailsSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 1 * 60 * 60 * 1000;

        ArrayList<CloudTimelineThumbnail> thumbnails = playerSDK.getTimelineThumbnailsSync(startTime, endTime);
        for (CloudTimelineThumbnail thumbnail : thumbnails) {
            Log.e(TAG, "thumbnail: " + CloudHelpers.objectToString(thumbnail));
        }
    }


    public void printThumbnailsWithLimit() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 60 * 60 * 1000;

        playerSDK.getTimelineThumbnails(startTime, endTime, 0, 10,false, "", null, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudTimelineThumbnail> thumbnails = (ArrayList<CloudTimelineThumbnail>)o_result;
            for (CloudTimelineThumbnail thumbnail : thumbnails) {
                Log.e(TAG, "thumbnail: " + CloudHelpers.objectToString(thumbnail));
            }
            return 0;
        });
    }

    public void printThumbnailsWithLimitSync() {
        long endTime = CloudHelpers.currentTimestampUTC();
        long startTime = endTime - 4 * 60 * 60 * 1000;

        ArrayList<CloudTimelineThumbnail> thumbnails = playerSDK.getTimelineThumbnailsSync(startTime, endTime, 0, 10,true, "", null);
        for (CloudTimelineThumbnail thumbnail : thumbnails) {
            Log.e(TAG, "thumbnail: " + CloudHelpers.objectToString(thumbnail));
        }
    }
}
