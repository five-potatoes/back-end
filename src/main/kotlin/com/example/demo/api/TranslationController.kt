package com.example.demo.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TranslationController {

    @GetMapping("/api/translation")
    fun getTranslation(): String {
        val fileName = "" // 파일을 저장하고, 그 파일의 이름을 저장한다.
        val translateResult = aiResult(fileName)
        return translateResult
    }

    private fun aiResult(fileName : String?) : String {
        // 인공지능 처리. 방법은 나중에
        return "인녕하세요. 반갑습니다."
    }

    @GetMapping("/api/test")
    fun getTest() : String = "this is test"

    @GetMapping("/api/aiaddr")
    fun getAiaddr() : String = "127.0.0.1"

    @GetMapping("/api/dbaddr")
    fun getDbaddr() : String = "127.0.0.1"
}