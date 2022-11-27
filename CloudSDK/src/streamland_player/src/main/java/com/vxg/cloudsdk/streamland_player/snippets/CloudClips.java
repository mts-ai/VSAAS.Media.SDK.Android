package com.vxg.cloudsdk.streamland_player.snippets;

import android.util.Log;
import android.util.Pair;

import com.vxg.cloud.core.CloudHelpers;
import com.vxg.cloudsdk.CloudPlayerSDK;
import com.vxg.cloudsdk.Interfaces.ICompletionCallback;
import com.vxg.cloudsdk.Interfaces.IInterruptedCallback;
import com.vxg.cloudsdk.Objects.CloudClip;
import com.vxg.cloudsdk.Objects.CloudTimelineSegment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

// https://web.vaplatform.ru/docs/v2.html#/storage%20(clips)
public class CloudClips {
    public final String TAG = CloudClips.class.getSimpleName();

    private final CloudPlayerSDK playerSDK;

    public CloudClips(CloudPlayerSDK sdk) {
        this.playerSDK = sdk;
    }

    public void printClips() {
        // print available clips
        long endClips = CloudHelpers.currentTimestampUTC();
        long startClips = endClips - 1 * 24 * 60 * 60 * 1000;

        String order = "";//""event_time";
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        //params.add(new Pair<>("event_time", "2022-11-08T00:00:01"));

        playerSDK.getClips(startClips, endClips,0, 100, false, order, params, (o_result, result) -> {
            if (result != 0) {
                return 0;
            }

            ArrayList<CloudClip> clips = (ArrayList<CloudClip>)o_result;
            Log.e(TAG, "clips count: " + clips.size());
            for (CloudClip clip : clips) {
                Log.e(TAG, "clip: " + CloudHelpers.objectToString(clip));
            }
            return 0;
        });
    }

    public void printClipsSync() {
        // print available clips
        long endClips = CloudHelpers.currentTimestampUTC();
        long startClips = endClips - 1 * 24 * 60 * 60 * 1000;

        String order = "";//""event_time";
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        //params.add(new Pair<>("event_time", "2022-11-08T00:00:01"));

        ArrayList<CloudClip> clips = playerSDK.getClipsSync(startClips, endClips,
                0, 100, false, order, params);
        Log.e(TAG, "clips count: " + clips.size());
        for (CloudClip clip : clips) {
            Log.e(TAG, "clip: " + CloudHelpers.objectToString(clip));
        }
    }


    public void clipDescription() {
        // get available clips
        long endClips = CloudHelpers.currentTimestampUTC();
        long startClips = endClips - 1 * 24 * 60 * 60 * 1000;

        String order = "";//""event_time";
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        //params.add(new Pair<>("event_time", "2022-11-08T00:00:01"));

        ArrayList<CloudClip> clips = playerSDK.getClipsSync(startClips, endClips,0, 100, false, order, params);
        Log.e(TAG, "clips count: " + clips.size());
        for (CloudClip clip : clips) {
            playerSDK.getClipDescription(clip.id, (o_result, result) -> {
                if (result != 0) {
                    return 0;
                }

                CloudClip requested = (CloudClip)o_result;
                Log.e(TAG, "check creating clip: " + CloudHelpers.objectToString(requested));
                return 0;
            });
        }
    }

    public void clipDescriptionSync() {
        // get available clips
        long endClips = CloudHelpers.currentTimestampUTC();
        long startClips = endClips - 1 * 24 * 60 * 60 * 1000;

        String order = "";//""event_time";
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        //params.add(new Pair<>("event_time", "2022-11-08T00:00:01"));

        ArrayList<CloudClip> clips = playerSDK.getClipsSync(startClips, endClips,0, 100, false, order, params);
        Log.e(TAG, "clips count: " + clips.size());
        for (CloudClip clip : clips) {
            CloudClip requested = playerSDK.getClipDescriptionSync(clip.id);
            Log.e(TAG, "check creating clip: " + CloudHelpers.objectToString(requested));

        }
    }


    public void createClipCompleteSync() {
        int clipCountGuard = 2;

        // get record segments as source for clip creation
        long end = CloudHelpers.currentTimestampUTC();
        long start = end - 1 * 60 * 60 * 1000;
        ArrayList<CloudTimelineSegment> segments =  playerSDK.getTimelineSegmentsSync(start, end);
        Log.e(TAG, "segments count: " + segments.size());
        for (CloudTimelineSegment segment : segments) {
            Log.e(TAG, "segment: " + CloudHelpers.objectToString(segment));

            // create clip
            long makeStart = segment.timeStart;
            long makeEnd = segment.timeStop;
            String title = "createClipComplete_" + CloudHelpers.formatTime(makeStart) + "__" + CloudHelpers.formatTime(makeEnd);
            CloudClip requested = playerSDK.createClipSync(title, makeStart, makeEnd, -1, null, 3000, new IInterruptedCallback() {
                @Override
                public Boolean isInterrupted() {
                    return false;
                }
            });

            Log.e(TAG, "create clip: " + CloudHelpers.objectToString(requested));
            clipCountGuard--;
            if (clipCountGuard <=0) {
                break;
            }
        }

        // print available clips clips after creation
        //printClips();
    }

    public void createClipSync() {
        int clipCountGuard = 2;

        // get record segments as source for clip creation
        long end = CloudHelpers.currentTimestampUTC();
        long start = end - 1 * 60 * 60 * 1000;
        ArrayList<CloudTimelineSegment> segments =  playerSDK.getTimelineSegmentsSync(start, end);
        Log.e(TAG, "segments count: " + segments.size());
        for (CloudTimelineSegment segment : segments) {
            Log.e(TAG, "segment: " + CloudHelpers.objectToString(segment));

            // start creating clip
            long makeStart = segment.timeStart;
            long makeEnd = segment.timeStop;
            String title = "createClip_" + CloudHelpers.formatTime(makeStart) + "__" + CloudHelpers.formatTime(makeEnd);

            CloudClip requested = playerSDK.startCreatingClipSync(title, makeStart, makeEnd, -1, null);
            Log.e(TAG, "try create clip: " + CloudHelpers.objectToString(requested));

            // wait for the creation process to complete
            while (requested.getStatus() == CloudClip.Status.pending) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                requested = playerSDK.getClipDescriptionSync(requested.id);
                Log.e(TAG, "check creating clip: " + CloudHelpers.objectToString(requested));
            }

            Log.e(TAG, "create clip: " + CloudHelpers.objectToString(requested));
            clipCountGuard--;
            if (clipCountGuard <=0) {
                break;
            }
        }

        // print available clips after creation
        //printClips();
    }

    public void createClip() {
        int clipCountGuard = 1;

        // get record segments as source for clip creation
        long end = CloudHelpers.currentTimestampUTC();
        long start = end - 1 * 60 * 60 * 1000;
        ArrayList<CloudTimelineSegment> segments =  playerSDK.getTimelineSegmentsSync(start, end);
        Log.e(TAG, "segments count: " + segments.size());
        for (CloudTimelineSegment segment : segments) {
            Log.e(TAG, "segment: " + CloudHelpers.objectToString(segment));

            // start creating clip
            long makeStart = segment.timeStart;
            long makeEnd = segment.timeStop;
            String title = "createClip_" + CloudHelpers.formatTime(makeStart) + "__" + CloudHelpers.formatTime(makeEnd);

            playerSDK.startCreatingClip(title, makeStart, makeEnd, -1, null, (o_result, result) -> {
                if (result != 0) {
                    return 0;
                }

                CloudClip requested = (CloudClip)o_result;
                Log.e(TAG, "try create clip: " + CloudHelpers.objectToString(requested));

                // wait for the creation process to complete
                while (requested.getStatus() == CloudClip.Status.pending) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                    }
                    requested = playerSDK.getClipDescriptionSync(requested.id);
                    Log.e(TAG, "check creating clip: " + CloudHelpers.objectToString(requested));
                }

                Log.e(TAG, "create clip: " + CloudHelpers.objectToString(requested));
                return 0;
            });
            clipCountGuard--;
            if (clipCountGuard <=0) {
                break;
            }
        }
        // print available clips after creation
        //printClips();
    }


    public void updateClips() {
        // get available clips
        long endClips = CloudHelpers.currentTimestampUTC();
        long startClips = endClips - 1 * 24 * 60 * 60 * 1000;

        String order = "";//""event_time";
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        //params.add(new Pair<>("event_time", "2022-11-08T00:00:01"));

        ArrayList<CloudClip> clips = playerSDK.getClipsSync(startClips, endClips,0, 100, false, order, params);
        Log.e(TAG, "clips count: " + clips.size());
        for (CloudClip clip : clips) {
            JSONObject params1 = new JSONObject();
            try {
                params1.put("title", clip.title + "_changed");
            } catch (JSONException ignored) {}

            playerSDK.updateStorageClip(clip.id, params1, (o_result, result) -> {
                if (result != 0) {
                    return 0;
                }

                CloudClip changed = (CloudClip)o_result;
                Log.e(TAG, "updated clip: " + CloudHelpers.objectToString(changed));
                return 0;
            });
        }
    }

    public void updateClipsSync() {
        // get available clips
        long endClips = CloudHelpers.currentTimestampUTC();
        long startClips = endClips - 1 * 24 * 60 * 60 * 1000;

        String order = "";//""event_time";
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        //params.add(new Pair<>("event_time", "2022-11-08T00:00:01"));

        ArrayList<CloudClip> clips = playerSDK.getClipsSync(startClips, endClips,0, 100, false, order, params);
        Log.e(TAG, "clips count: " + clips.size());
        for (CloudClip clip : clips) {
            JSONObject params1 = new JSONObject();
            try {
                params1.put("title", clip.title + "_changed");
            } catch (JSONException ignored) {}

            CloudClip changed = playerSDK.updateStorageClipSync(clip.id, params1);
            Log.e(TAG, "updated clip: " + CloudHelpers.objectToString(changed));
        }
    }


    public void deleteClipsForCameraId(long camId) {
        playerSDK.deleteClip(camId, -1, (o_result, result) -> {
            Log.e(TAG, "delete clip result: " + result);
            return 0;
        });
        //printClips();
    }

    public void deleteClipsForCameraIdSync(long camId) {
        int resultDelete = playerSDK.deleteClipSync(camId, -1);
        Log.e(TAG, "delete clip result: " + resultDelete);
        //printClips();
    }


    public void deleteClipsForClipId() {
        int clipCountGuard = 2;
        long endClips = CloudHelpers.currentTimestampUTC();
        long startClips = endClips - 1 * 24 * 60 * 60 * 1000;

        String order = "";//""event_time";
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        //params.add(new Pair<>("event_time", "2022-11-08T00:00:01"));

        ArrayList<CloudClip> clips = playerSDK.getClipsSync(startClips, endClips,
                0, 100, false, order, params);
        Log.e(TAG, "1. clips count: " + clips.size());

        for (CloudClip clip : clips) {
            playerSDK.deleteClip(clip.id, (o_result, result) -> {
                Log.e(TAG, "delete clip result: " + result);
                return 0;
            });
            clipCountGuard--;
            if (clipCountGuard <=0) {
                break;
            }
        }

        //printClips();
    }

    public void deleteClipsForClipIdSync() {
        int clipCountGuard = 2;
        long endClips = CloudHelpers.currentTimestampUTC();
        long startClips = endClips - 1 * 24 * 60 * 60 * 1000;

        String order = "";//""event_time";
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        //params.add(new Pair<>("event_time", "2022-11-08T00:00:01"));

        ArrayList<CloudClip> clips = playerSDK.getClipsSync(startClips, endClips,
                0, 100, false, order, params);
        Log.e(TAG, "1. clips count: " + clips.size());

        for (CloudClip clip : clips) {
            int resultDelete = playerSDK.deleteClipSync(clip.id);
            Log.e(TAG, "delete clip result: " + resultDelete);
            clipCountGuard--;
            if (clipCountGuard <=0) {
                break;
            }
        }

        //printClips();
    }
}
