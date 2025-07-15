
<script>

//alert("This is a simple form. You can modify it as needed.");

$(document).ready(function () {
    tinyMCE.init({  
        // General options  
        mode : "specific_textareas",
        editor_selector : "mceEditorReadOnly",
        theme : "advanced",
        readonly : "true",
        plugins : "autoresize",
        //plugins : "pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave",  
        language : lang, 
      
        // ACCESSIBILITY SETTINGS  
        content_css : "/${backContext}/css/default.css,/${backContext}/css/bootstrap.css,/${backContext}/css/bootstrap.min.css",
        // Use browser preferred colors for dialogs.  
        browser_preferred_colors : true,  
        detect_highcontrast : true,
        
        // TTT
        theme_advanced_default_foreground_color: "#FFFFFF"
    }); 
});



</script>