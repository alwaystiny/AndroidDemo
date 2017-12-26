package com.code.demo.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * Created by liunian on 2017/12/26.
 * 图片压缩的工具类
 * 图片压缩一般有三种方法：质量压缩、采样率压缩、比例压缩
 * 图片在硬盘中以file形式存在、在安卓内存中以bitmap或者stream、上传下载时以stream形式存在
 * 内存中的bitmap的大小有getByteCount() 计算出大小(关联Bitmap.Config、像素点、分辨率)
 */
class FileSizeUtils {

    /**
     * 质量压缩
     * 质量压缩不会改变bitmap的大小 只会改变file的大小，不会影响分辨率。
     * @param bitmap
     * @param quality 压缩的质量0-100，100为不压缩
     * @param file 图片的存储file
     */
    fun compressQuality(bitmap:Bitmap,quality:Int,file: File) {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,quality,baos)
        var fos = FileOutputStream(file)
        fos.write(baos.toByteArray())
        fos.flush()
        fos.close()
    }


    /**
     * 采样率压缩
     * @param filePath 文件路径
     * @param file 图片的存储file
     * @param inSampleSize 采样率压缩的参数
     */
    fun compressSampleSize(filePath:String,file:File,inSampleSize:Int){

        var options = BitmapFactory.Options()
        options.inJustDecodeBounds = false
        options.inSampleSize = inSampleSize
        var decodeFile = BitmapFactory.decodeFile(filePath, options)
        compressQuality(decodeFile,100,file)
    }

    /**
     * 谷歌提供的计算sampleSize的方法
     *
     */
    fun calculateInSampleSize(options:BitmapFactory.Options,reqWidth:Int,reqHeight:Int) : Int{
        var outWidth = options.outWidth
        var outHeight = options.outHeight
        var inSampleSize = 1
        if (outHeight>reqHeight||outWidth>reqWidth){
            var halfHeight = outHeight / 2
            var halfWidth = outWidth / 2
            while ((halfHeight/inSampleSize)>=reqHeight || (halfWidth/inSampleSize)>=reqWidth){
                inSampleSize*=2
            }
        }
        return inSampleSize
    }

    /**
     * 尺寸压缩
     * 显著压缩bitmap的大小 ，一般按照一个指定的比例循环压缩，直到合适的尺寸
     * @param bitmap
     * @param file 图片的存储file
     */
    fun compressSize(bitmap: Bitmap,file: File){
        var radio = 8
        var createBitmap = Bitmap.createBitmap(bitmap.width / radio, bitmap.height / radio, Bitmap.Config.RGB_565)
        var canvas = Canvas(createBitmap)
        var rect = Rect(0, 0, bitmap.width / radio, bitmap.height / radio)
        canvas.drawBitmap(bitmap,null,rect,null)

        compressQuality(bitmap,100,file)
    }
}