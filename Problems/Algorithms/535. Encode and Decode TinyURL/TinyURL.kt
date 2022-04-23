class Codec() {
    
    val map: MutableMap<String, String> = mutableMapOf()
    val sb: StringBuilder = StringBuilder()
    
    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        sb.append((0..100).random().toChar())
        while(map.containsKey(sb.toString())){
            sb.append((0..100).random().toChar())
        }
        map.put(sb.toString(), longUrl)
        return sb.toString()
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return map.getOrDefault(shortUrl, "")
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var url = obj.encode(longUrl)
 * var ans = obj.decode(url)
 */
