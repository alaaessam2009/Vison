package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("    <title> CAM </title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write(" <link   rel=\"stylesheet\"  href=\"indexStyle.css\"  type=\"text/css\"  >\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <!-- Navigation bar -->\r\n");
      out.write("  <!-- Home Navgation --> <a id=\"homeNav\"> </a>  <!-- Home Navgation -->\r\n");
      out.write("   <header>\r\n");
      out.write("     <div class=\"container\">\r\n");
      out.write("         <b class=\"logo\">  VISON </b>\r\n");
      out.write("         <!-- Home Navgation --> <!-- -->\r\n");
      out.write("\r\n");
      out.write("        <nav>\r\n");
      out.write("           <ul>\r\n");
      out.write("              <li>  <a href=\"#homeNav\">Home</a>   </li>\r\n");
      out.write("              <li>  <a href=\"#aboutNav\">About </a>   </li>\r\n");
      out.write("              <li>  <a href=\"#contactNav\">Contact </a>   </li>\r\n");
      out.write("              <li> <a href=\"nameCompareCompanies.jsp\">Comparison </a>   </li>\r\n");
      out.write("              <li>  <a href=\"login.jsp\"> Login</a>   </li>\r\n");
      out.write("              <li>  <a href=\"whichsign.html\"> Sign up</a>   </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("     </nav>\r\n");
      out.write("   </div>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("   </header>\r\n");
      out.write("\r\n");
      out.write("   <!-- Navigation bar -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <!-- search Field  -->\r\n");
      out.write("\r\n");
      out.write(" <form class=\"search\"  action=\"search\" >\r\n");
      out.write("\r\n");
      out.write("   <input type=\"text\" placeholder=\"Company Name\" autocomplete=\"off\" name=\"searchField\">\r\n");
      out.write("   <button type=\"submit\">  <i class=\"fa fa-search\"> search</i>  </button>\r\n");
      out.write("\r\n");
      out.write(" </form>\r\n");
      out.write("\r\n");
      out.write("  <!-- search Field  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     <!-- Footer Menu -->\r\n");
      out.write("        <!-- Contact Navgation --> <a id=\"contactNav\"> </a>  <!-- Contact Navgation -->\r\n");
      out.write("        <!-- Contact Navgation --> <a id=\"aboutNav\"> </a>  <!-- Contact Navgation -->\r\n");
      out.write(" <div class=\"parent-div\">\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("        <div class=\"contactus-div\">\r\n");
      out.write("          <h3> Contact Us </h3>\r\n");
      out.write("          <ul class=\"ul-contactus\">\r\n");
      out.write("             <li> <i class=\"fa fa-map-marker\">&nbsp &nbsp Seattle ,USA  </i> </li>\r\n");
      out.write("             <li> <i class=\"fa fa-phone\">&nbsp &nbsp +9256336577 </i> </li>\r\n");
      out.write("             <li> <i class=\"fa fa-envelope-o\">&nbsp &nbsp alaaessam2009@gmail.com </i> </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <div class=\"aboutus-div\">\r\n");
      out.write("           <h3> About Us </h3>\r\n");
      out.write("            <p> The world has become so fast paced that people<br>\r\n");
      out.write("                don’t want to stand by reading a page of information, <br>\r\n");
      out.write("                they would much rather look at a presentation <br>\r\n");
      out.write("                and understand the message. It has come to a point\r\n");
      out.write("            </p>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <div class=\"followus-div\">\r\n");
      out.write("           <h3 class=\"follow-header\"> Follow Us </h3>\r\n");
      out.write("           <ul class=\"ul-followus\">\r\n");
      out.write("             <li>  <a href=\"http://www.facebook.com\" target=\"_blank\">  <i class=\"fa fa-facebook\"></i></a>  </li>\r\n");
      out.write("             <li>  <a href=\"https://twitter.com\" target=\"_blank\">  <i class=\"fa fa-twitter\"></i></a>  </li>\r\n");
      out.write("             <li>  <a href=\"http://www.youtube.com\" target=\"_blank\">  <i class=\"fa fa-youtube\"></i></a>  </li>\r\n");
      out.write("             <li>  <a href=\"https://www.instagram.com\" target=\"_blank\">  <i class=\"fa fa-instagram\"></i></a>  </li>\r\n");
      out.write("             <li>  <a href=\"https://www.linkedin.com/\" target=\"_blank\">  <i class=\"fa fa-linkedin\"></i></a>  </li>\r\n");
      out.write("           </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("    <div class=\"message-div\">\r\n");
      out.write("        \r\n");
      out.write("     <form action=\"sendMessage\">            \r\n");
      out.write("         <input class=\"message_input\" type=\"text\" placeholder=\"Name\"  required autocomplete=\"off\" name=\"name\" >                     \r\n");
      out.write("       <input class=\"message_input\" type=\"text\" placeholder=\"Email\" required autocomplete=\"off\" name=\"email\" > \r\n");
      out.write("       <textarea class=\"message_input\" placeholder=\"Message\" rows=\"8\" cols=\"38\" required name=\"message\"></textarea>   \r\n");
      out.write("        \r\n");
      out.write("       <input class=\"message-submit\" type=\"submit\" value=\"Send\" >\r\n");
      out.write("       \r\n");
      out.write("     </form>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" </div>\r\n");
      out.write("     <!-- Footer Menu -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" </body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
