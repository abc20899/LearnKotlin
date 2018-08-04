function test(s){
   return 'java call js Rhino' + s;
}
function test2(d){
   return d;
}
function filterUrl(sourceIndex,url){
   switch(sourceIndex){
       case 1:
         return filter1(url);
         break;
       case 2:
         break;
       case 3:
         break;
   }
}
function filter1(urlStr){
    var url = urlStr.toString();
    if(url.indexOf("pl-ali.youku.com") != -1 || url.indexOf("pl-m3u8.youku.com") != -1 ||
         url.indexOf("pl.cp12.wasu.tv") != -1){
       return url.toString();
    }else if(url.indexOf("ts.m3u8") != -1 && url.indexOf("qq.com") != -1
        && url.indexOf("btrace.video.qq.com") == -1){
       return url.toString();
    }else if(url.indexOf("v.smtcdns.com") != -1 && url.indexOf("qq.com") != -1 && url.indexOf("apd-") != -1
        && url.indexOf("btrace.video.qq.com") == -1){
       return url.toString();
    }
}