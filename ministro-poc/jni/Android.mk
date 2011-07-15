LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

APP_ABI := armeabi armeabi-v7a

LOCAL_MODULE    := libhelper
LOCAL_CFLAGS    := -Werror
LOCAL_SRC_FILES := helper.c
#LOCAL_LDLIBS    := -llog

include $(BUILD_SHARED_LIBRARY)
