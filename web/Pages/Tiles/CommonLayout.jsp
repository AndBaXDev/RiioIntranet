<%-- 
    Document   : CommonLayout
    Created on : Feb 7, 2019, 10:24:52 AM
    Author     : andressolanoramirez
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
--%>
<!doctype html>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>        
        <title>Peji Site</title>        
        
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        
        <link rel="stylesheet" href="Styles/NavMenu.css" />
        <link rel="stylesheet" href="Styles/Site.css" />
        <script src="Scripts/ASRScripts.js" type="text/javascript"></script>   
        <link rel="stylesheet" href="Styles/Alertify/themes/default.min.css" />
        <link href="Styles/Alertify/alertify.min.css" rel="stylesheet" type="text/css" media="screen" />
        
        <script src="Scripts/alertify.min.js"></script>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
        crossorigin="anonymous"></script>

        <!-- Bootstrap files (jQuery first, then Popper.js, then Bootstrap JS) -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" type="text/javascript"></script>


        <script type="text/javascript">
        /// some script

        // jquery ready start
        $(document).ready(function() {
                // jQuery code

                ///////////////// fixed menu on scroll for desctop
            if ($(window).width() > 992) {

                var navbar_height =  $('.navbar').outerHeight();

                $(window).scroll(function(){  
                    if ($(this).scrollTop() > 300) {
                                         $('.navbar-wrap').css('height', navbar_height + 'px');
                         $('#navbar_top').addClass("fixed-top");

                    }else{
                        $('#navbar_top').removeClass("fixed-top");
                        $('.navbar-wrap').css('height', 'auto');
                    }   
                });
            } // end if


        }); // jquery end
        </script>

        <style type="text/css">
            
            .colorMenu{
                background: rgba(0,105,152,0.7) !important;  
            }

            .fixed-top.navbar{ padding:0px;  }
            .bg-primary{
                background: rgba(0,105,152,0.7) !important;               
            }
        </style>
    </head>
    <body>
        <tiles:insert attribute="header"/>

        <tiles:insert attribute="body"/> 

        <tiles:insert attribute="footer"/> 
    </body>
</html>
