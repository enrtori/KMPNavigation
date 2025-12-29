package com.enri.navigator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform