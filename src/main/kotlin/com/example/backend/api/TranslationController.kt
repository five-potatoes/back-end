package com.example.backend.api

import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/translation")
class TranslationController {
    /*
    * multipartFile 을 이용하여 동영상을 전송받는다.
    * 해당 방법을 통해 전송받으려면 반드시 post 방식을 이용해야한다.
    * 파일을 서버에 저장 > 성공시 번역 요청 > 번역 결과를 받고 해당 결과를 프론트에 전송 (> 동영상 삭제)
     */
    
    @PostMapping("/v2t")
    fun getVideoToTextTranslation(@RequestParam("file") file: MultipartFile?)
    : String {

        // 파일을 저장하고, 그 파일의 이름을 저장한다.
//        val fileName = uploadFile(file)

        // 저장한 파일의 파일 이름을 통해 번역 요청
//        val translateResult = aiResult(fileName)
        val translateResult = "안녕하세요. 반갑습니다."

        // 반환받은 번역결과를 프론트에 전송한다.
        return translateResult
    }

    private fun generateFileNameToTime(extension : String): String {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
        return currentDateTime.format(formatter) + extension
    }

    private fun uploadFile(file : MultipartFile?) : String {
        // 업로드된 파일을 저장할 디렉터리 설정
        val uploadDir = File("upload-video")
        if(!uploadDir.exists()) {
            uploadDir.mkdirs()
        }

        // 파일을 저장한다.
        val newFile = File(uploadDir, file?.originalFilename ?: generateFileNameToTime(".mp4"))
        val outputStream = FileOutputStream(newFile)
        file?.bytes?.let { outputStream.write(it) }
        outputStream.close()

        return newFile.name
    }

    private fun aiResult(fileName : String?) : String {
        // 인공지능 처리. 방법은 나중에
        return "인녕하세요. 반갑습니다."
    }

    @PostMapping("/t2v")
    fun getTextToVideoTranslation(@RequestParam("text") text : String)
    //: ResponseEntity<InputStreamResource> {
    : String {
        // 전달받은 문자열을 분할한다. 조사는 떼고 단어만 추출한다.
        // ai hub를 통해 전달한다.


        // 각 단어에 맞는 영상을 DB에서 가져온다.


        // 전달받은 영상을 합친다.


        return "동영상이 전송되었습니다."
    }


    @GetMapping("/test")
    fun getTest() : String = "this is test"
}

