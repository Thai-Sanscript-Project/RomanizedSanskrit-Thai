package sanskrit.romanized.thai;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thanakrit.P
 *
 * k = ก (กะ)	kh = ข (ขะ)	g = ค (คะ)	gh = ฆ (ฆะ)	ṅ = ง (งะ) c = จ (จะ)	ch = ฉ
 * (ฉะ)	j = ช (ชะ)	jh = ฌ (ฌะ)	ñ = ญ (ญะ) ṭ = ฏ (ฏะ)	ṭh = ฐ (ฐะ)	ḍ = ฑ (ฑะ)	ḍh=
 * ฒ (ฒะ)	ṇ = ณ (ณะ) t = ต (ตะ)	th = ถ (ถะ)	d = ท (ทะ)	dh = ธ (ธะ)	n = น (นะ) p
 * = ป (ปะ)	ph = ผ (ผะ)	b = พ (พะ)	bh = ภ (ภะ)	m = ม (มะ) y = ย (ยะ)	r = ร (ระ)
 * l = ล (ละ)	v = ว (วะ)	ś = ศ (ศะ) ṣ = ษ (ษะ)	s = ส (สะ)	h = ห (หะ)
 *
 * a = –ะ, –ั	ā = –า	i = –ิ	ī = –ี	u = –ุ ū = –ู	ṛ
 * (เมื่ออยู่ต้นคำหรือตามหลังพยัญชนะ) = ฤ e = เ–	ai = ไ–	o = โ–	o (ตามหลังสระ) =
 * ว	au = เ–า ṁ (ใช้แทนจันทรพินทุ) = ง	ṃ (ใช้แทนอนุสวาร) = ง	ḥ = ห์
 *
 */
public class MappingCharacter {

    public static Map<String, String> mappingThaiVowelInFist() {

        Map mapping = new HashMap<>();

        mapping.put("ะ", "อะ");
        mapping.put("า", "อา");
        mapping.put("ิ", "อิ");
        mapping.put("ี", "อี");
        mapping.put("ุ", "อุ");
        mapping.put("ู", "อู");
        mapping.put("เ", "เอ");
        mapping.put("โ", "โอ");

        return mapping;
    }

    public static Map<String, String> mappingSingleVowel() {

        Map mapping = new HashMap<>();
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

    public static Map<String, String> mappingMixVowel() {

        Map mapping = new HashMap<>();

        mapping.put("ai", "ไ");
        mapping.put("au", "เา");
        mapping.put("r̥", "ฤ");

        return mapping;
    }

    public static Map<String, String> mappingSingleConsonant() {

        Map mapping = new HashMap<>();

        mapping.put("k", "ก");
        mapping.put("g", "ค");
        mapping.put("ṅ", "ง");

        mapping.put("c", "จ");
        mapping.put("j", "ช");
        mapping.put("ñ", "ญ");

        mapping.put("ṭ", "ฏ");
        mapping.put("ḍ", "ฑ");
        mapping.put("ṇ", "ณ");

        mapping.put("t", "ต");
        mapping.put("d", "ท");
        mapping.put("n", "น");

        mapping.put("p", "ป");
        mapping.put("b", "พ");
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
        mapping.put("'", "'");

        return mapping;
    }

    public static Map<String, String> mappingMixConsonant() {

        Map mapping = new HashMap<>();
//khchṭhthphn̄ghjhḍhdhbh
        mapping.put("kh", "ข");
        mapping.put("ch", "ฉ");
        mapping.put("ṭh", "ฐ");
        mapping.put("th", "ถ");
        mapping.put("ph", "ผ");

        mapping.put("n̄", "ญ");

        mapping.put("gh", "ฆ");
        mapping.put("jh", "ฌ");
        mapping.put("ḍh", "ฒ");
        mapping.put("dh", "ธ");
        mapping.put("bh", "ภ");

        return mapping;
    }

    public static Map<String, Boolean> mappingIsThaiVowel() {

        Map<String, Boolean> revert = new HashMap<>();
        revert.put("ั", Boolean.TRUE);

        Map<String, String> singleVowel = MappingCharacter.mappingSingleVowel();
        revert = MappingCharacter.setRevertFlag(revert, singleVowel);

        Map<String, String> mixVowel = MappingCharacter.mappingMixVowel();
        revert = MappingCharacter.setRevertFlag(revert, mixVowel);

        return revert;
    }

    public static Map<String, Boolean> mappingIsThaiConsonant() {

        Map<String, Boolean> revert = new HashMap<>();
        revert.put("อ", Boolean.TRUE);
        Map<String, String> single = MappingCharacter.mappingSingleConsonant();
        revert = MappingCharacter.setRevertFlag(revert, single);

        Map<String, String> mix = MappingCharacter.mappingMixConsonant();
        revert = MappingCharacter.setRevertFlag(revert, mix);

        return revert;
    }

    public static Map<String, Boolean> setRevertFlag(Map<String, Boolean> revert, Map<String, String> revertMap) {

        for (Map.Entry<String, String> entrySet : revertMap.entrySet()) {

            String value = entrySet.getValue();
            if (revert.get(value) == null) {
                revert.put(value, Boolean.TRUE);
            }
        }

        return revert;
    }

}
