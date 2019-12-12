"# springboot-acl-bypass" 
最近遇到url  判断不当绕过acl验签的问题

都是getRequestURI的大锅

//inter/hello  
/open/..;/inter/hello  
/open/../inter/hello  
/inter/hello.aaaaa  
/inter/hello;a.js  
各种大坑接连不断  
谨慎背锅  
