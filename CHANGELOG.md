# VXG Mobile SDK Android

### MobileSDK 2.0.341

CloudSDK
Version 2.0.341_20250130:
- added Sleep Service API support to BE API

PlayerSDK
Version 6.96.20241024:

EncoderSDK
Version 6.13.20240829:

### MobileSDK 2.0.340

CloudSDK
Version 2.0.340_20250108:
- refactored for support several REST API providers
- added BE REST API support
- added settings for backend path configuration
- added new settings for missed parameters in BE access token:
  identityId, cameraId, cameraShareToken.

PlayerSDK
Version 6.96.20241024:
- optimized stream opening time

EncoderSDK
Version 6.13.20240829:

### MobileSDK 2.0.339

CloudSDK
Version 2.0.339_20241024:
- updated versions of used SDK:
  PlayerSDK: 6.96.20241024
- optimized stream opening time for inactive camera

PlayerSDK
Version 6.96.20241024:
- optimized stream opening time

EncoderSDK
Version 6.13.20240829:

### MobileSDK 2.0.338

CloudSDK
Version 2.0.338_20240927:
- updated versions of used SDK:
  PlayerSDK: 6.96.20240927

PlayerSDK
Version 6.96.20240927:
- corrected notification status flow for recording streams without data

EncoderSDK
Version 6.13.20240829:

### MobileSDK 2.0.337

CloudSDK
Version 2.0.337_20240829:
- updated versions of used SDK:
  PlayerSDK: 6.96.20240829
  EncoderSDK: 6.13.20240829
- fixed possible issue with missed notification about recording stop on reconnect

PlayerSDK
Version 6.96.20240829:
- enabled transcoding only for g711 and mp4 container
- improved transcoding functionality

EncoderSDK
Version 6.13.20240829:
- builded for use latest ffmpeg

### MobileSDK 2.0.336

CloudSDK
Version 2.0.336_20240816:
- updated versions of used SDK:
  PlayerSDK: 6.96.20240816
- added the ability to select the recording container type
- added new settings for recording container type
- fixed a possible issue with live stream stopping after the camera became active
- added new setting: workaroundWaitUntilLiveStreamCompletelyReady

PlayerSDK
Version 6.96.20240816:
- added the ability to select the recording container type
- added new settings for recording container type

EncoderSDK
Version 6.13.20240529:

### MobileSDK 2.0.335

CloudSDK
Version 2.0.335_20240722:
- fixed a possible crash in CloudPlayerView for some locales

PlayerSDK
Version 6.96.20240606:

EncoderSDK
Version 6.13.20240529:

### MobileSDK 2.0.334

CloudSDK
Version 2.0.334_20240611:
- fixed a possible crash in GetTimelineDays if a timeout occurred
- fixed a possible deadlock on the reconnect when losing and restoring
  a live stream from a camera

PlayerSDK
Version 6.96.20240606:

EncoderSDK
Version 6.13.20240529:

### MobileSDK 2.0.333

CloudSDK
Version 2.0.333_20240606:
- updated versions of used SDK:
  PlayerSDK: 6.96.20240606
- fixed possible crash on PTZ execute command

PlayerSDK
Version 6.96.20240606:
- added optional callback to monitor current position of playing stream
- added new callback: OnStreamPositionDidChange

EncoderSDK
Version 6.13.20240529:

### MobileSDK 2.0.332

CloudSDK
Version 2.0.332_20240529:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20240529
  EncoderSDK: 6.13.20240529
- fixed possible static context memory leaks
- migrate API ids from Interger to Long

PlayerSDK
Version 6.96.20240529:
- updated license list

EncoderSDK
Version 6.13.20240529:
- fixed possible static context memory leaks
- updated license list

### MobileSDK 2.0.331

CloudSDK
Version 2.0.331_20240503:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20240503
  EncoderSDK: 6.13.20240503
- added offset emulation for getTimeline API
- added delete storage data API support
- added order_by support for getTimeline
- added new API support:
  getTimelineSegment, deleteTimelineSegment, deleteTimelineSegments
- added deleteTimeline command alias
- updated snippets

PlayerSDK
Version 6.96.20240503:
- updated license list
- fixed memory leaks

EncoderSDK
Version 6.13.20240503:
- updated license list

### MobileSDK 2.0.330

CloudSDK
Version 2.0.330_20240424:
- fixed crash in getTimeline method
- fixed getTimelineDays method when used with setSourceForAPIOnly

PlayerSDK
Version 6.96.20240228:

EncoderSDK
Version 6.13.20240417:

### MobileSDK 2.0.329

CloudSDK
Version 2.0.329_20240417:
- updated versions of used SDK:
  EncoderSDK: 6.13.20240417

PlayerSDK
Version 6.96.20240228:

EncoderSDK
Version 6.13.20240417:
- added the ability to apply various filters to input audio data

### MobileSDK 2.0.328

CloudSDK
Version 2.0.328_20240228:
- updated versions of used SDK:
  PlayerSDK: 6.96.20240228
- added the ability to use the CloudPlayerSDK without view
- added constructor with context parameter
- removed the requirement for the context to be activity
- added getLiveUrls methods

PlayerSDK
Version 6.96.20240228:
- added the ability to hot change the surface for rendering
- improved functionality for working with surface loss
- improved audio / video synchronization
- improved thumbnailer funstionality and speed
- fixed possible thumbnailer deadlock
- fixed low speed issue on some streams
- fixed crash when there is no view renderer

EncoderSDK
Version 6.13.20231019:

### MobileSDK 2.0.324

CloudSDK
Version 2.0.324_20231222:
- fixed existed getTimelineDays methods according latest VXG API changes
- added new parameters for getTimelineDays
- added new parameters for getTimeline method
- added new methods: getEventsTypes

PlayerSDK
Version 6.96.20231215:

EncoderSDK
Version 6.13.20231019:

### MobileSDK 2.0.323

CloudSDK
Version 2.0.323_20231215:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20231215
- greatly improved memory consumption and cpu utilization
- added framerate control
- added buffer size and type configuration for video and audio renderer
- fixed getVideoShot functionality
- added a lot of new settings:
  dataReceiveTimeout,
  videoKeyframeOnly,
  synchroNeedDropVideoFrames,
  advancedConnectionNetworkProtocolBufferSize,
  advancedConnectionNetworkProtocolPacketSize,
  advancedSourceAsyncGetPacket,
  advancedVideoRendererPreferredFpsNum,
  advancedVideoRendererPreferredFpsDen,
  internalPlayerMode,
  internalBufferSourceVideodecoderType,
  internalBufferSourceVideodecoderSize,
  internalBufferVideodecoderVideorendererType,
  internalBufferVideodecoderVideorendererSize,
  internalBufferSourceAudiodecoderType,
  internalBufferSourceAudiodecoderSize,
  internalBufferAudiodecoderAudiorendererType,
  internalBufferAudiodecoderAudiorendererSize

PlayerSDK
Version 6.96.20231215:
- greatly improved memory consumption and cpu utilization
- added framerate control
- added buffer size and type configuration for video and audio renderer
- fixed player mode functionality for playback pipeline configuration
- fixed getVideoShot functionality
- added new settings:
  advancedConnectionNetworkProtocolBufferSize 
  advancedConnectionNetworkProtocolPacketSize
  advancedVideoRendererPreferredFpsNum
  advancedVideoRendererPreferredFpsDen

EncoderSDK
Version 6.13.20231019:

### MobileSDK 2.0.322

CloudSDK
Version 2.0.322_20231201:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20231201

PlayerSDK
Version 6.96.20231201:
- fixed getVideoShot method
- fixed double start notify for record functionality

EncoderSDK
Version 6.13.20231019:

### MobileSDK 2.0.321

CloudSDK
Version 2.0.321_20231019:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20231019
  EncoderSDK: 6.13.20231019
- fixed possible dead locks in local player functionality
- fixed configuration not being applied before opening local player

PlayerSDK
Version 6.96.20231019:
- migrated on the ffmpeg based VPS/SPS/PPS parsing

EncoderSDK
Version 6.13.20231019:


### MobileSDK 2.0.319

CloudSDK
Version 2.0.319_20230908:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20230908
  EncoderSDK: 6.13.20230908
- added new API support: CameraAVSettingsVideo
- added possiblity reconnect on the video output format changed notify
- added new advanced config settings:
  decodingType
  reconnectOnVideoOutputFormatChanged
  workaroundRemoveBackwardDiscontinuityForGetData

PlayerSDK
Version 6.96.20230908:
- added support for dynamic change of video stream resolution
- added support for restarting pts video and audio streams
- added notify VDP_OUTPUT_FORMAT_CHANGED
- added HWACCEL decoding support
- added new advanced config settings for restarting pts functionality
  workaroundRemoveBackwardDiscontinuityForGetData

EncoderSDK
Version 6.13.20230908:

FFMPEG:
Version 6.0.0:
- added mediacodec support
- fixed mediacodec dynamic change format issue

### MobileSDK 2.0.315

 CloudSDK
Version 2.0.315_20230630:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20230629
  EncoderSDK: 6.13.20230512
- improved live and backward url request logic
- added new configure setting for backward url type
- improved getPosition method accuracy
- improved data IO error handling
- added new advanced config settings:
  *WorkaroundRemoveBackwardJumpsForGetPosition,
  *AdvancedSourcePtsModifyMode,
  *AdvancedOptionReconnectDelayStep


 PlayerSDK
Version 6.96.20230629:
- fixed problems related to migration to FFMPEG version 6.0.0
- improved getaddrinfo async version on the ffmpeg level
- added http reconnect delay step setting on the ffmpeg level
- removed jumps back for get stream and renderer position methods after changing position
- corrected data flush after successful position change
- improved data IO error handling
- added new advanced config settings for new features:
  advancedSourcePtsModifyMode
  advancedSourceOptionHttpReconnectDelayStep
  workaroundRemoveBackwardJumpsForGetPosition

 EncoderSDK
Version 6.13.20230512:

### MobileSDK 2.0.314

 CloudSDK
Version 2.0.314_20230515:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20230512
  EncoderSDK: 6.13.20230512
- improved live stream opening speed
- added new method onLiveUrlsProvider in PlayerCallback with the ability to set a live url
- added new advanced config settings for tune low latency and fast detection stream functionality:
  *AdvancedOptionInitWithFastStreamDetection,
  *AdvancedOptionInitWithLowLatency,
  *AdvancedOptionTcpNoDelay,
  *AdvancedOptionAnalyzeDuration,
  *AdvancedOptionHlsReloadPlaylistInterval
- added new advanced config setting for auto reconnect after data io error occurred:
  *reconnectOnErrorDataIO
- added new advanced config setting for enable internal get camera status check:
  *enableCameraStatusCheck  

 PlayerSDK
Version 6.96.20230512:
- migrated on ffmpeg.6.0.0
- added new low latency functionality
- improved stream fast detection functionality
- added new data IO error support
  CP_ERROR_DATA_IO
- added new advanced config settings:
  advancedSourceOptionTcpNoDelay,
  advancedSourceOptionAnalyzeDuration,
  advancedSourceOptionHlsReloadPlaylistInterval,
  advancedSourceInitWithFastStreamDetection,
  advancedSourceInitWithLowLatency
- fixed possible crash on close

 EncoderSDK
Version 6.13.20230512:
- migrated on ffmpeg.6.0.0
- fixed problem with loading native part

### MobileSDK 2.0.313

 CloudSDK
Version 2.0.313_20230322:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20230322
  EncoderSDK: 6.13.20230322

 PlayerSDK
Version 6.96.20230322:
- updated license list

 EncoderSDK
Version 6.13.20230322:
- updated license list

### MobileSDK 2.0.312

 CloudSDK
Version 2.0.312_20230320:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20230320
  EncoderSDK: 6.13.20230320
- added camera status monitoring for opening

 PlayerSDK
Version 6.96.20230320:
- updated license list

 EncoderSDK
Version 6.13.20230320:
- updated license list

### MobileSDK 2.0.310

 CloudSDK
Version 2.0.310_20230306:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20230306
  EncoderSDK: 6.13.20230306

 PlayerSDK
Version 6.96.20230306:
- updated license list
- fixed issue in ffmpeg rtsp setup command and related digest authentication

 EncoderSDK
Version 6.13.20230306:
- updated license list

### MobileSDK 2.0.309

 CloudSDK
Version 2.0.309_20221230:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20221230

 PlayerSDK
Version 6.96.20221230:
- fixed a possible crash when using an external surface that 
  is already in the window hierarchy
- fixed possible issues related to Tagget Pointers technology 
  on Android 13

 EncoderSDK
Version 6.13.20221201:

### MobileSDK 2.0.308

 CloudSDK
Version 2.0.308_20221201:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20221201
  EncoderSDK: 6.13.20221201

 PlayerSDK
Version 6.96.20221201:
- updated license list

 EncoderSDK
Version 6.13.20221201:
- updated license list

### MobileSDK 2.0.307

 CloudSDK
Version 2.0.307_20221130:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20221130
  EncoderSDK: 6.13.20221130

 PlayerSDK
Version 6.96.20221130:
- updated license list

 EncoderSDK
Version 6.13.20221130:
- updated license list

### MobileSDK 2.0.306

 CloudSDK
Version 2.0.306_20221129:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20221129
  EncoderSDK: 6.13.20221129

 PlayerSDK
Version 6.96.20221129:
- updated license list

 EncoderSDK
Version 6.13.20221129:
- updated license list

### MobileSDK 2.0.305

 CloudSDK
Version 2.0.305_20221127:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20221127
  EncoderSDK: 6.13.20221127
- addec clips API support
- improved APIs for timeline, activity, events, records, thumbnails
- added code snippets in the player example
- fixed a lot of bugs and typos

 PlayerSDK
Version 6.96.20221127:
- updated license list

 EncoderSDK
Version 6.13.20221127:
- updated license list

### MobileSDK 2.0.304

 CloudSDK
Version 2.0.304_20221118:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20221118
- added fixes for latest Cloud API changes
- fixed issues with playning records on the Android 13
- improved internal surface switching processing
- added access for new advanced PlayerSDK config settings

 PlayerSDK
Version 6.96.20221118:
- added new advanced config settings:
  probesize, fpsprobesize, formatprobesize, max_probe_packets, live_start_index, rtmp_buffer, rtmp_live

 EncoderSDK
Version 6.13.20220824:

### MobileSDK 2.0.303

 CloudSDK
Version 2.0.303_20220906:
- reverted back getPosition behavior

 PlayerSDK
Version 6.96.20220824:

 EncoderSDK
Version 6.13.20220824:

### MobileSDK 2.0.302

 CloudSDK
Version 2.0.302_20220905:
- fixed return value issue for getposition during setposition
- added new events support: SEEK_STARTED, SEEK_FAILED

 PlayerSDK
Version 6.96.20220824:

 EncoderSDK
Version 6.13.20220824:

### MobileSDK 2.0.301

 CloudSDK
Version 2.0.301_20220824:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20220824,
  EncoderSDK: 6.13.20220824

 PlayerSDK
Version 6.96.20220824:
- updated license list

 EncoderSDK
Version 6.13.20220824:
- updated license list

### MobileSDK 2.0.300

 CloudSDK
Version 2.0.300_20220812:
- added support for get/set position when playing url (local playback)

 PlayerSDK
Version 6.96.20220707:

 EncoderSDK
Version 6.13.20220707:

### MobileSDK 2.0.299

 CloudSDK
Version 2.0.299_20220707:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20220707,
  EncoderSDK: 6.13.20220707

 PlayerSDK
Version 6.96.20220707:
- migrated to openssl version 1.1.1q

 EncoderSDK
Version 6.13.20220707:
- migrated to openssl version 1.1.1q

### MobileSDK 2.0.298

 CloudSDK
Version 2.0.298_20220705:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20220705,
  EncoderSDK: 6.13.20220705

 PlayerSDK
Version 6.96.20220705:
- migrated openssl to version 1.1.1p
- migrated to FFMPEG version 4.4.2

 EncoderSDK
Version 6.13.20220705:
- migrated openssl to version 1.1.1p
- migrated to FFMPEG version 4.4.2

### MobileSDK 2.0.297

 CloudSDK
Version 2.0.297_20220622:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20220622
- added the ability to configure the behavior of the sequence of double taps

 PlayerSDK
Version 6.96.20220622:
- added support double tap gesture for all aspect ratio zoom/move modes
- added the ability to configure the behavior of the sequence of double taps

 EncoderSDK
Version 6.13.20220518:

### MobileSDK 2.0.296

 CloudSDK
Version 2.0.296_20220618:
- fixed CloudStreamer connection conflict issue

 PlayerSDK
Version 6.96.20220411:

 EncoderSDK
Version 6.13.20220518:

### MobileSDK 2.0.294

 CloudSDK
Version 2.0.294_20220419:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20220411,
  EncoderSDK: 6.13.20220419
- added a few checks for avoid Cloud Player crashes

 PlayerSDK
Version 6.96.20220411:
- fixed possible deadlock in the HW video decoder implementation

 EncoderSDK
Version 6.13.20220419:
- fixed missing jjffmpeg module issue
- fixed secure streaming config setting

### MobileSDK 2.0.292

 CloudSDK
Version 2.0.292_20220325:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20220325,
- fixed Cloud Player freeze issue
- fixed Cloud record segments playing issue
- updated streamland_player sample

 PlayerSDK
Version 6.96.20220325:
- added https(s) protocol to non-interruptable protocols list

 EncoderSDK
Version 6.13.20220317:

### MobileSDK 2.0.291

 CloudSDK
Version 2.0.291_20220317:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20220317,
  EncoderSDK: 6.13.20220317
- added new callback onStatusWillShow for CloudPlayerView
- corrected error handling

 PlayerSDK
Version 6.96.20220317:
- migrated to OpenSSL version 1.1.1n with fixed latest critical CVE

 EncoderSDK
Version 6.13.20220317:
- migrated to OpenSSL version 1.1.1n with fixed latest critical CVE
- fixed secure streaming config setting

### MobileSDK 2.0.288

 CloudSDK
Version 2.0.288_20220217:
- added local record API for cloud streams 
- added cloudplayer config settings for detection and buffering time
- moved refresh token functionality on CloudAPI level
- added a few config settings for refresh token functionality
- fixed open/close sequence for CloudPlayerView

 PlayerSDK
Version 6.96.20211223:

 EncoderSDK
Version 6.12.20211223:

### MobileSDK 2.0.286

 CloudSDK
Version 2.0.286_20211223:
- updated versions of used SDK: 
  PlayerSDK: 6.96.20211223,
  EncoderSDK: 6.12.20211223
- added new advanced settings: 
  reconnect on http error for hls sources.
  default value: 404

 PlayerSDK
Version 6.96.20211223:
- fixed the problem with passing 64-bit pointers to ffmpeg by dictionary
- fixed AAC ASC gegenrated config from stream info
- added configuration setting for generate ASC. Default: 0
- added new advanced settings: reconnect on http error. Default: 404

 EncoderSDK
Version 6.12.20211223:
- fixed MediaStreamTest sample

### MobileSDK 2.0.284

 CloudSDK
Version 2.0.284_20211118:
- added support for Gradle 7, Android SDK 30, Android NDK 23, Java 8
- updated versions of used SDK: 
  PlayerSDK: 6.96.20211118,
  EncoderSDK: 6.12.20211118
- added new config for CloudPlayerSDK with the possibility of protocol and port selection (secure or insecure)
- added new config for CloudStreamerSDK with the possibility of protocol and port selection (secure or insecure)
- default CloudStreamerSDK mode is now secure (HTTPS, WSS, RTMPS)
- added workaround to wait until records will upload for a position less than 1 min from the current time
- added new settings for 2 workarounds:
  switch on HLS for tokens with path
  wait for records upload
- added new API CloudPlayerSDK::setSourceForAPIOnly. Will prepare SDK without a player for API command use only
- fixed a few memory leaks
- updated and cleaned samples

 PlayerSDK
Version 6.96.20211118:
- added support for Gradle 7, Android SDK 30, Android NDK 23, Java 8
- migrated to FFMPEG version 4.4.1
- migrated to OpenSSL version 1.1.1l and used as a shared library
- added ONVIF device manager
- added new API for setup internal buffers type: 0 - default, 1 - based on mmap
- added new API for setup internal buffers sizes
- added new config setting: advancedUseAsyncGetAddrInfo
- improved EOS detection algorithm
- added support audio-only mode for instance with video surface
- fixed Software video decoder crash on YUV P10 formats
- fixed records flags for mp4
- fixed issue with wrong shader matrix for 180 and 270 rotation
- updated and cleaned samples

 EncoderSDK
Version 6.12.20211118:
- added support for Gradle 7, Android SDK 30, Android NDK 23, Java 8
- migrated to FFMPEG version 4.4.1
- migrated to OpenSSL version 1.1.1l and used as a shared library
- camera video preview modes exposed to public config API
- improved overlay support
- improved error handling
- updated and cleaned samples

### MobileSDK 2.0.262

 CloudSDK
Version 2.0.262_20201203
- Improved timeline 
- Improved calendar
- Fixed loading problem after failed connection
- Fixed not stopped timeline after close
- Added possiblity setup liveurl type (rtmp, rtmps, hls, rtsp)
- Added "live" button
- Corrected status callbacks sequence from CloudPlayer

 PlayerSDK
Version 6.96.20201203
- added time shift functionality
- added workaround for remove unrecognized NALUs
- added workaround to get stream information from extra data 
  if standard way failed

 EncoderSDK
Version 6.12.20201203
- Added overlay
- Added screen audio capture
- Useed SurfaceView for any mode except offscreen rendering
- Converted ServiceStream sample to AndroidX
- Recording Pause/Resume added
- Ttranscoder: rewing sps/pps buffer 
- Added possibility setup custom resolution
- Added TakeScreenshot but only for VIRTUAL_DISPLAY capture

### MobileSDK 2.0.243

 CloudSDK
Version 2.0.243_20200916
- Fixed issue when getVideoShot try get not scaled data
- Added external surface support for local player
  functionality
- Added synchronization of the modified player config with
  the cloud player config
- Getting backward url considering the expiration date
- Added monitor for tracking changes in live url while 
  connecting to stream

 PlayerSDK
Version 6.96.20200916
- Fixed SW decoder configuration for mpeg2 type
- Fixed multi instance ffmpeg initialization issue
- Added notification STREAMINFO_NOT_COMPLETE

 EncoderSDK
Version 6.09.20200123

### MobileSDK 2.0.237

 CloudSDK
Version 2.0.237_20200715

 PlayerSDK
Version 6.96.20200715

 EncoderSDK
Version 6.09.20200123
 
### MobileSDK 2.0.171

 CloudSDK
Version 2.0.171_20190805
- Fixed setting timeline for empty interval
- Added file for uploading
- Fixed setting timeline screen range
- Fixed setting timeline screen range
- Fixed screen sensor
- Added option to set  color of loader 
- Added PTZ control for local and cloud cameras
- Fixed hiding cameramanipulator on timeout
- Disabled audio in the grid control 
- Set decode only key frame in grid control
- Fixed crash in executeAsynkTask
- Fixed loader in Local camera 

### MobileSDK 2.0.153

 PlayerSDK
Version 6.96.20190807
- Fixed recording in record only mode, if trim not specified
- Added new sample DrawOverVideo

 EncoderSDK
Version 6.07.20190520
- Fixed close state

 CloudSDK
Version 2.0.144_20190730
- Improved timeline movements using arrows, responsiveness
- Fixed recording for cloud
- Fixed issue with CloudPlayer change position
- Improved CloudPlayerView 

### MobileSDK 2.0.140

EncoderSDK
v6.07.20190520
Fixed RTMPS streaming to Facebook (save non-blocking flags)


### MobileSDK 2.0.139
 PlayerSDK
Version 6.95.20190712
- Added LOW\_DELAY flag in s/w decoder if decoder\_latency is ON
- WebRTC: Do not wait for recvonly media on start
- Fixed issue in playlist parser on 64-bit systems
- Added check for interruption on mediaformat\_find\_stream\_info stage
- WebRTC: Use copy buffer for webrtc backward audio 
- Fixed subtitle pointer typos
- Fixed crash for rtsp content provider if wrong sprops received
- Fixed: skip rtp packets with unknown payload type
- WebRTC: Added pts validation

 CloudSDK
Version 2.0.138_20190712
- Added screen curtain on player view
- Added custom mode scale drawing, intervals drawing
- Added custom thumb
- Fixed custom video records
- Added new cloud player mode - player3
- Added lock, aspect buttons to player3 mode
- Fixed crash in Timeline 
- Fixed scale dates
- Fixed empty record on timeline

### MobileSDK 2.0.131
 PlayerSDK
Version 6.94.20190523
- Changed version for openssl . openssl-1.1.1a	 

 EncoderSDK:
v6.07.20190520
- Changed version for openssl . openssl-1.1.1a
	 

### MobileSDK 2.0.129
 PlayerSDK
Version 6.93.20190507
- Fixed crash with multi players and rtsp source
- Get_Range works woth npt time.
- Fixed crash for rtsp content provider if wrong sprops received
- skip rtp packets with unknown payload type
- Fixed issue with get range when npt comes from RTSP server

 EncoderSDK: 
v6.07.20190520
- Added Zoom and Flash control 

 CloudSDK
v2.0.129_20190525
- Added MediaPlayer in CloudMultiPlayerViewAdapter
- Added LocalPlayer object 
- Added Closed event to detect that player is closed
- CloudPlayerView can be used like MediaPlayer and like CloudPlayer.
- Fixed getVideoShot in LocalCamera 
- Added recording for local camera 
- Fixed Play/Pause/Aspect Ratio in LocalPlayer
- Fixed crash on  Grid
- Fixed issue with cloud camera in Grid
- Added OnSwipeTouchListener in CloudPlayerView
- Added OnClick is handled on touch listener
- Added setRange method in CloudPlayerView 

### MobileSDK 2.0.113
 PlayerSDK
Version 6.91.20190312 
- Fixed : PTS is calculated based on range_start_offset
- Fixed crash on close for rtsplib source  
- Fixed partialy initialized audio stream for rtsplib source
- Added Player2 to VideoPlayer sample : sample is able to control position in RTSP or local file, change Rate and Position.
- Fixed  SW video decoder is crashed if the desired resolution is less than the real
- Fixed : Change position if position is 0
- Added WebRTC backward audio (it is not include to current build, library is provided by request)
- Fixed SDP is not played 
- Added options for TLS:
   setSSLPEMFilePath		- set path to file Privacy Enhanced Mail
   setSSLPEMBuffer		- set Privacy Enhanced Mail as buffer
   setSSLTLSCipherSiutes	- set TLS version : 10 - TLS 1.0, 11 - TLS 1.1, 12 - TLS 1.2,
   setSSLTLSVersion		- tls cipher siutes  
   setSSLSessionCacheSize	- set ssl session cache size: 0 - disable, -1 - infinite
   setSendKeepAlive		- set keep-alive header in HTTP request	 1 - send "keep-alive" in http header, 0 - do not include "keep-alive"


### MobileSDK 2.0.107
 PlayerSDK
Version 6.88.20190206 (ONVIF control , RTSP position control , RTSP scale control, AI interface)
- Added ONVIF support . 
  URL Format: 
  onvif://
  http:// + onvif/device_service
  https:// + onvif/device_service
- Added API interface to control PTZ over ONVIF
  PTZ_ContinuousMove, PTZ_RelativeMove, PTZ_AbsoluteMove, PTZ_Zoom, PTZStop, PTZPreset 
- Added event : ONVIF_PTZ_IS_SUPPORTED is raised if there is PTZ support in camera capabiltes  
- Added speed control for RTSP : setRtspPlaybackScale. "Scale:" header is added in PLAY command.
- Added change position for rtsplib network source
- Added draw object over video functionality 
- Fixed scale for rtsplib network source
- Fixed issue on Play/Pause and changing scale    
- Fixed issue when playback in RTSP is changed from negative to positive 
- Fixed playabck if RTSP speed is -x1 
- Fixed recording AAC and PCMU in mp4 if network source is rtsplib
MobileSDK
Fixed segment uploader 

### MobileSDK 2.0.91
 PlayerSDK
 - Remove user and password from RTSP handshake in VXG RTSP source
 - Added option videoKeyFrameOnly (Network source provides key frames only)
 - Added support of H.265 in RTSP source 
 - Added function setRtspPlaybackScale . This function is used to change rate on RTSP camera during playback
 - Fixed issue backward playback (I-Frames are played only) 

### MobileSDK 2.0.75
  - VXG.ONVIF.Android added.
  - Xamarin MediaPlayer sample added.
  - MediaPlayerSDK. ver.6.46.20181204 added.
  - MediaCaptureSDK. ver. 6.06.20181204 added.

### MobileSDK 2.0.74
  - CloudPlayerView. 
> current position corrected with timezone.
> prev/next buttons handled.

### MobileSDK 2.0.73
  - CloudPlayerView. 
> fullscreen rotation corrected.
> timeline for STYLE_YOUTUBE enabled.

### MobileSDK 2.0.72
  - CloudPlayerView improved. styles added
>STYLE_YOUTUBE
>STYLE_STREAMLAND

### MobileSDK 2.0.71
  - CloudAPI. deleteCameraRecords added.
  - CloudStreamer. 
>int deleteSegmentSync(long timeStart, long timeStop);
>int deleteSegment(long timeStart, long timeStop, ICompletionCallback callback); added.

### MobileSDK 2.0.70
  - CloudMultiPlayerView. resources for grid corrected.

### MobileSDK 2.0.69
  - Fixed crashes regarding Context usage.
  - Fixed crashes regarding check network BroadcastReceiver.

### MobileSDK 2.0.68
  - MediaPlayerSDK + MediaCaptureSDK, armeabi arch removed. 

### MobileSDK 2.0.67
  - CloudMultiPlayerView. corrected for Landscape mode.

### MobileSDK 2.0.66
  - fixed crash in RTSP server on arm64-v8a 
  - CloudMultiPlayerView added.
> compile 'com.vxg.mediasdk:playersdk:2.0.66'
> compile 'com.vxg.mediasdk:encodersdk:2.0.66'
> compile 'com.vxg.cloudsdk:cloudsdk:2.0.66'

### MobileSDK 2.0.60
  - Latest packages built with targetAPI = 26:
> compile 'com.vxg.mediasdk:playersdk:2.0.60'
> compile 'com.vxg.mediasdk:encodersdk:2.0.60'
> compile 'com.vxg.cloudsdk:cloudsdk:2.0.60'


### MobileSDK 2.0.59
  - VXG.MediaPlayer.Android Version 6.45.20180821
> AudioBackward API added
> test app MediaPlayerSDKTest_AudioBackward added


### MobileSDK 2.0.58
  - repo link changed "http://exchange.videoexpertsgroup.com:8080/repository/internal/" => "http://android.vxg.io/repository/internal/"
  - Samples built with targetAPI = 26.
  - CloudSDK.  processing cookies in sdk added; 
  - CloudStreamer: Interface for backward audio prepared
  - CloudPlayer:
> addition check on camera == ACTIVE added.
> CloudPlayerView. bug: onError returns result 0. fixed.
> config changed: setConnectionDetectionTime 5000=>2000; default config is not applied on re-open stream.
> getBackwardAudioUrl() method added.


### MobileSDK 2.0.57
  - CloudViewConfig.setEnableControl() fixed.


### MobileSDK 2.0.56
  - CloudPlayer:
> check Camera status on getting live url added.
> getPosition(). return value only in range.
> event SEEK_COMPLETED sending corrected for live mode.
  - Hanging of timeline thumb fixed
  - CloudPlayerView, CloudPlayerViewConfig added.
  - added setConfig(), getConfig().
  - added induvidual settings for controls:
> public enum ControlType{
> CTL_PROGRESS,
> CTL_TXT_POSITION,
> CTL_TXT_DURATION,
> CTL_BTN_PLAYPAUSE,
> CTL_BTN_FULLSCREEN,
> CTL_TIMELINE
> };


### MobileSDK 2.0.55
  - Added support platforms armeabi, armeabi-v7a, x86, arm64-v8a
  - CloudSDK. CloudPlayerView added, see streamland_player sample.
  - MediaCaptureSDK ver.6.06.20180724 
> fixed crash on network off, after avio_open(&cptr->pb, cptr->filename, AVIO_FLAG_WRITE) error
> MediaCaptureConfig.setAudioSource(int) added. MediaRecorder.AudioSource.MIC by default
> shared ffmpeg with VXG.MediaPlayerSDK, platforms arm64-v8a armeabi armeabi-v7a x86 added
> added ALAW/MULAW audio codec configurations
> VR_1920x1200 resolution added
  - Latest packages :
> compile 'com.vxg.mediasdk:playersdk:2.0.55'
> compile 'com.vxg.mediasdk:encodersdk:2.0.55'
> compile 'com.vxg.cloudsdk:cloudsdk:2.0.55'

### MobileSDK 2.0.41
  - CloudStreamer. WebSocket error handled on CM reconnect.
  - CloudStreamerSDK. added restoring CM on network off/on.
  - streamland_streamer app. added support SSL connection on devices Android <= 4.3.
  - CloudStreamer. resetCameraManager() removed.
  - CloudCamera. 'clipsplay' access property added.

### MobileSDK 2.0.40
  - VXG.MediaEncoder.Android ver.6.05.20180515 updated.
> Camera Facing CAMERA_FACING_FRONT  corrected. 
> Camera filter CAMERA_FILTER_FLIP_X mode corrected

### MobileSDK 2.0.39
  - CloudSDK. logging corrected.
  - CloudStreamerSDK. API getCamera() returned 200 on network off. fixed.
  - CloudStreamer. returns code ERROR_TOO_MANY_REQUESTS added on duplicate connect to the same CM.

### MobileSDK 2.0.38
  - CloudStreamerSDK added functions for upload segments and thumbnails:
> int putTimelineSegmentSync(long timeStart, long timeStop, String fileSegment);
> int putTimelineSegment(long timeStart, long timeStop, String fileSegment, ICompletionCallback callback);
> int putTimelineThumbnailSync(long time, String fileThumbnail);
> int putTimelineThumbnail(long time, String fileThumbnail, ICompletionCallback callback);
  - CloudStreamerSDK+CloudPlayerSDK added functions for download segments and thumbnails:
> ArrayList<CloudTimelineSegment> getTimelineSegmentsSync(long timeStart, long timeStop);
> int getTimelineSegments(long timeStart, long timeStop, ICompletionCallback callback);
> ArrayList<CloudTimelineThumbnail> getTimelineThumbnailsSync(long timeStart, long timeStop);
> int getTimelineThumbnails(long timeStart, long timeStop, ICompletionCallback callback);

### MobileSDK 2.0.37
  - CloudStreamerSDK
> putTimelineSegment()/putTimelineSegmentSync() added
> fixed bug (Error=-2) on local cloud.
  - MediaPlayer.SDK Version 6.03.20180409 added

### MobileSDK 2.0.36
  - CloudStreamerSDK. second start streaming onto local cloud fixed

### MobileSDK 2.0.35
  - "How to use the license key.pdf" added
  - VXG.MediaEncoder.Android ver.6.05.20180327 
> disable VERBOSE flag. 
> MediaCaptureConfig copy constructor corrected
  - VXG.MediaPlayer.Android ver.6.05.20180327 
> Segment playback added
> MediaPlayerConfig copy constructor corrected

### MobileSDK 2.0.33
  - VXG.MediaEncoder.Android (MediaCaptureSDK ver. 6.04.20180315) improved
> Offscreenrenderer improved. startRecord/stopRecord added.

### MobileSDK 2.0.32
  - VXG.MediaEncoder.Android (MediaCaptureSDK ver. 6.04.20180314) improved
> RTMP+RTSP+Rec Main+Secondary channels added. Individual start/stop added.
> CAMERA_FILTER_CUSTOM_VERTEX_SHADER, CAMERA_FILTER_CUSTOM_FRAGMENT_SHADER added

### MobileSDK 2.0.31
  - VXG.MediaEncoder.Android (MediaCaptureSDK ver. 6.04.20180312) improved
> cameraFacing FRONT camera added
> set camera preview corrected
> setCameraFilter() added. CAMERA_FILTER_NONE(default), CAMERA_FILTER_FLIP_X
> getRTMPStatus() marked @Deprecated

### MobileSDK 2.0.30
  - StreamLand. Playback of recorded video improved.

  - MediaCapture.SDK ver.6.01.20180222
> ABR control added.
> Tests updated. Bitrate mode added. ABR set by default.

  - MediaPlayer.SDK Version 6.01.20180214
> Added new feature : LatencyControl setting
> Fixed issue : Open/Close on thread

### MobileSDK 2.0.22
  - CloudCamera. enableSharingForStream() corrected.

### MobileSDK 2.0.21
  - MediaCaptureSDK, MediaPlayerSDK ver 5.97.20180209 added.
  - CloudHelpers. added helper functions isLocalUrl(), isPublicUrl().
  - CloudCameraList. fixed bug related to deleteCameraSync() on api == null.

### MobileSDK 2.0.20
  - StreamLand Streamer. bug: frequent reconnects to cloud. fixed.
  - codeclean. Showing 'Demo limitation' text corrected.

### MobileSDK 2.0.19
  - MediaEncoderSDK ver.5.97.20180202. added x86 arch support

### MobileSDK 2.0.18
  - Build on the base updated VXG.MediaSDK Player and Encoder ver.5.97.20180201.

### MobileSDK 2.0.17
  - StreamLand Streamer improved:
> fixed bug related to ERROR_NOT_CONFIGURED = -2 on start streaming

### MobileSDK 2.0.16
  - StreamLand Player improved:
> TimeLine added;
> ProgressBar on connection added.
  - StreamLand Streamer improved:
> Changing of Access Token handled;
> TRIAL_VERSION event handled.

### MobileSDK 2.0.15
  - Renamed CloudSDK=>MobileSDK

### CloudSDK 2.0.15
  - SDK structure changed. Added VXG.MediaSDK and VXG.StreamLand

### CloudSDK 2.0.9
  - CloudPlayerSDK and CloudStreamerSDK revised.

### CloudSDK 2.0.8
  - Removed TestServer from samples.
 
### CloudSDK 2.0.7
  - Added connection for StreamLand Player and StreamLand Streamer applications to TestServer to get channels/access tokens
  - License scheme applied

### CloudSDK 2.0.6
  - StreamLand Player added
  - StreamLand Streamer added
  - snippets 1-6 moved to adminAPI

### CloudSDK 2.0.5
  - CloudStreamer. Transcoding PLAYER=>CAPTURE added
  - CloudCameraList. createCameraForStream() added.
  - MediaPlayerSDK lib updated
  - MediaCaptureSDK lib ver. 5.1.20171124 updated
  - Capture source PP_MODE_SURFACE for getting surface from PLAYER=>CAPTURE.
  - CloudCamera improved, given below methods implemented:
> //location coordinates
> void setLatLngBounds(double latitude, double longitude);
> double getLat();
> double getLng();
> ArrayList<Long> getTimelineDaysSync(boolean use_timezone);
>    int           getTimelineDays(boolean use_timezone, ICompletionCallback callback);
  - CloudCameraListFilter. setForStream(boolean ) option added.


### CloudSDK 2.0.4
  - CloudCamera. save() method corrected
  - CloudCameraList. findOrCreateCamera( url) added
  - CloudCameraListFilter. setPrivacy(PS_Privacy privacy) added
  - snippets1-6 corrected.

### CloudSDK 2.0.3
  - Timeline and Calendar added
  - CloudHelpers. formatTime_withSSSSSS() and parseUTCTime() corrected
  - CloudPlayer. ICloudObject getSource(); function added.
  - CloudPlayer. addCallback()/removeCallback() added
  - Progress on setPosition() added.
  - CloudConnection. bug: singleton connection. fixed.
  - CloudCameraList. getCamera(), deleteCamera() corrected.


### CloudSDK 2.0.2
  - getServerTimeDiff() added, playback live getPosition() improved.
  - CloudCameraFilter, latitude/longitude settings added.
  - Log wrapper improved. android.Log => MLog to enable/disable all log.
  - CloudSDK impoved. set enable/disable log, log level added.
  - CloudPlayerConfig class added according to the document.
  - snippet_getCameraPreviewUrl(camera)

### CloudSDK 2.0.1
  - playback of camera records added.
  - play/pause, set/get position implemented
  - switch live/rec playback modes implemented
  - CloudUserInfo implemented
  - snippets added:
> snippet_createCamera_by_url( url )
> snippet_show_userinfo (camera)
> snippet_createCamera_by_id(id)
> snippet_delete_all_cameras()
> snippet_camera_get_timeline(camera)
> snippet_camera_start_record(camera)


### CloudSDK 2.0.0
  - first version
  - snippet_createCamera_by_url( url ) added.
  - playback of live cameras
  - get status of camera
  - start camera record added
  - get camera timeline 
