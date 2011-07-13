/*
    Copyright (c) 2011, BogDan Vatra <bog_dan_ro@yahoo.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

#include <jni.h>
#include <sys/stat.h>

void Java_eu_licentia_necessitas_poc_ministro_Ministro2_makeWorldReadable(JNIEnv * env, jobject obj, jstring filePath)
{
    const char *file = (*env)->GetStringUTFChars(env, filePath, 0);
    chmod(file, 0644);
    (*env)->ReleaseStringUTFChars(env, filePath, file);
}
