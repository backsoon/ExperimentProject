/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class fenceProxy_jni */

#ifndef _Included_fenceProxy_jni
#define _Included_fenceProxy_jni
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     fenceProxy_jni
 * Method:    FenceStart
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_fenceProxy_1jni_FenceStart
  (JNIEnv *, jobject, jstring, jstring, jstring);

/*
 * Class:     fenceProxy_jni
 * Method:    FenceEnd
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_fenceProxy_1jni_FenceEnd
  (JNIEnv *, jobject);

/*
 * Class:     fenceProxy_jni
 * Method:    getLastError
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_fenceProxy_1jni_getLastError
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
