package sanskrit.romanized.thai;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thanakrit.P
 * 
 * k = ก (กะ)	 kh = ข (ขะ)	 g = ค (คะ)	 gh = ฆ (ฆะ)	 ṅ = ง (งะ)
 * c = จ (จะ)	 ch = ฉ (ฉะ)	 j = ช (ชะ)	 jh = ฌ (ฌะ)	 ñ = ญ (ญะ)
 * ṭ = ฏ (ฏะ)	 ṭh = ฐ (ฐะ)	 ḍ = ฑ (ฑะ)	 ḍh= ฒ (ฒะ)	 ṇ = ณ (ณะ)
 * t = ต (ตะ)	 th = ถ (ถะ)	 d = ท (ทะ)	 dh = ธ (ธะ)	 n = น (นะ)
 * p = ป (ปะ)	 ph = ผ (ผะ)	 b = พ (พะ)	 bh = ภ (ภะ)	 m = ม (มะ)
 * y = ย (ยะ)	 r = ร (ระ)	 l = ล (ละ)	 v = ว (วะ)	 ś = ศ (ศะ)
 * ṣ = ษ (ษะ)	 s = ส (สะ)	 h = ห (หะ)
 * 
 * a = –ะ, –ั	 ā = –า	 i = –ิ	 ī = –ี	 u = –ุ
 * ū = –ู	 ṛ (เมื่ออยู่ต้นคำหรือตามหลังพยัญชนะ) = ฤ
 * e = เ–	 ai = ไ–	 o = โ–	 o (ตามหลังสระ) = ว	 au = เ–า
 * ṁ (ใช้แทนจันทรพินทุ) = ง	 ṃ (ใช้แทนอนุสวาร) = ง	 ḥ = ห์
 * 
 */
public class MappingRomanizeThai {
    
     public static Map<String, String> mappingSingle() {
        
         Map mapping = new HashMap<>();

        mapping.put("k", "ก");
        mapping.put("c", "จ");
        mapping.put("ṭ", "ฏ");
        mapping.put("t", "ต");
        mapping.put("p", "ป");

        mapping.put("g", "ค");
        mapping.put("j", "ช");
        mapping.put("ḍ", "ฑ");
        mapping.put("d", "ท");
        mapping.put("b", "พ");

        mapping.put("ṅ", "ง");
        mapping.put("ñ", "ญ");
        mapping.put("ṇ", "ณ");
        mapping.put("n", "น");
        mapping.put("m", "ม");

        mapping.put("y", "ย");
        mapping.put("r", "ร");
        mapping.put("l", "ล");
        mapping.put("v", "ว");
        mapping.put("ś", "ศ");
        mapping.put("ṣ", "ษ");
        mapping.put("s", "ส");
        mapping.put("h", "ห");

        mapping.put("ṁ", "ง");
        mapping.put("ṃ", "ง");
        mapping.put("ḥ", "หฺ");

        mapping.put("a", "ะ");
        mapping.put("ā", "า");
        mapping.put("i", "ิ");
        mapping.put("ī", "ี");
        mapping.put("u", "ุ");
        mapping.put("ū", "ู");
        mapping.put("ṛ", "ฤ");
        mapping.put("e", "เ");
        mapping.put("ē", "เ");
        mapping.put("ō", "โ");
        mapping.put("o", "โ");

        return mapping;
    }

    public static Map<String, String> mappingPair() {
        
        Map mapping = new HashMap<>();

        mapping.put("kh", "ข");
        mapping.put("ch", "ฉ");
        mapping.put("ṭh", "ฐ");
        mapping.put("th", "ถ");
        mapping.put("ph", "ผ");

        mapping.put("gh", "ฆ");
        mapping.put("jh", "ฌ");
        mapping.put("ḍh", "ฒ");
        mapping.put("dh", "ธ");
        mapping.put("bh", "ภ");

        mapping.put("ai", "ไ");
        mapping.put("au", "เา");
        mapping.put("r̥", "ฤ");

        return mapping;
    }
    
}