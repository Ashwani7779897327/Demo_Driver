//package com.apporio.demotaxiappdriver.others;
//
//import com.ice.restring.Restring;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class SampleStringsLoader implements Restring.StringsLoader {
//
//    @Override
//    public List<String> getLanguages() {
//        return Arrays.asList("en", "de", "fa","ar");
//    }
//
//    @Override
//    public Map<String, String> getStrings(String language) {
//        Map<String, String> map = new HashMap<>();
//        switch (language) {
//            case "en": {
//               // map.put("loading", "loading_en");
//                map.put("subtitle", "This is subtitle (from restring).");
//                break;
//            }
//            case "de": {
//               // map.put("loading", "loading_fr");
//                map.put("subtitle", "Das ist Untertitel (from restring).");
//                break;
//            }
//            case "fa": {
//                //map.put("loading", "loading_fa");
//                map.put("subtitle", "In matn ast (from restring).");
//                break;
//            }
//            case "ar": {
//               // map.put("loading", "loading_ar");
//                map.put("subtitle", "In matn ast (from restring).");
//                break;
//            }
//        }
//        return map;
//    }
//
//}
