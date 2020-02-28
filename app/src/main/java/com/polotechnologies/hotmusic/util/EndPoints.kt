package com.polotechnologies.hotmusic.util

class EndPoints {

    companion object{
        val topArtists = "http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=fe4256a1374cab3e71b4d9d9dc6e39c5&format=json"
        val topTracks = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=fe4256a1374cab3e71b4d9d9dc6e39c5&format=json"


        val tagsTopAlbums = "http://ws.audioscrobbler.com/2.0/?method=tag.gettopalbums&tag=disco&api_key=fe4256a1374cab3e71b4d9d9dc6e39c5&format=json"
        val tagsTopArtists = "http://ws.audioscrobbler.com/2.0/?method=tag.gettopartists&tag=disco&api_key=fe4256a1374cab3e71b4d9d9dc6e39c5&format=json"
        val tagsTopTracks = "http://ws.audioscrobbler.com/2.0/?method=tag.gettoptracks&tag=disco&api_key=fe4256a1374cab3e71b4d9d9dc6e39c5&format=json"

    }
}