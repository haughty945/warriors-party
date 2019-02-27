package com.mine.warriorsservercommon.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @program: warriors-party
 * @description: Excel工具类
 * @author: Mine.Lee
 * @create: 2019-02-27 16:26
 * @version: v1.0
 * @remark: ..
 */
public class ExcelUtil {

    /**
     * @description Excel 导出工具类
     * @remark ...
     *  1) content-Type 告诉浏览器用什么软件可以打开此文件
     *  2) Content-Disposition 下载文件的默认名称
     *  3) CharacterEncoding 编码
     * @author Mine.Lee
     * @create 2019/2/27 16:29
     * @return void
     * @param  response HttpServletResponse
     * @param  datas 封装excel的数据集
     * @param  fileName 导出结果的文件名
     * @throws IOException
     */
    public static void ExportExcel(HttpServletResponse response, List<?> datas, String fileName) throws IOException {
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8") + ".xls");
        response.setCharacterEncoding("UTF-8");
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), datas.get(0).getClass(), datas);
        workbook.write(response.getOutputStream());
    }

    /**
     * @description Excel 导入解析工具类
     * @remark ..
     *  1)headRows 标题行
     *  2)titleRows 标题行
     * @author Mine.Lee
     * @create 2019/2/27 16:33
     * @return java.util.List<?>
     * @throws Exception
     */
    public static List<?> importExcel(MultipartFile file, Class<?> clazz) throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        importParams.setTitleRows(0);
        return ExcelImportUtil.importExcelMore(file.getInputStream(), clazz, importParams).getList();
    }

}
