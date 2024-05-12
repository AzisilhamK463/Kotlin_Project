package com.azdev.testapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student (val name: String?, val nim: String?): Parcelable