/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.31
 * Generated at: 2018-05-26 18:46:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;
import model.BreizhLink;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/Users/nadjimchabane/ServeurJEE/Projet/target/tomcat.8080/webapps/expanded/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153377882000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1527359756000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.BreizhLink");
    _jspx_imports_classes.add("model.User");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 User user = (User) request.getSession().getAttribute("user");
      out.write('\n');
 BreizhLink breizhLink = (BreizhLink) request.getAttribute("breizhLink");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>Home</title>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../WEB-INF/ressource.jsp", out, false);
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../WEB-INF/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"jumbotron\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("          <div class=\"col-xs-12\">\n");
      out.write("            <h2>Bienvenue sur BREIZHLINK</h2>\n");
      out.write("              <form method='post' action='breizh' class=\"form-horizontal\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                  <label for=\"link_url\" class=\"col-sm-2 control-label\">URL à raccourcir</label>\n");
      out.write("                  <div class=\"col-sm-10\">\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"http://example.com\" id=\"link_url\" name=\"link_url\">\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                  <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                    <div class=\"checkbox\">\n");
      out.write("                      <label>\n");
      out.write("                        <input type=\"checkbox\" data-toggle=\"collapse\" href=\"#collapseExample\" role=\"button\" aria-expanded=\"false\" aria-controls=\"collapseExample\"> Sécurisée avec mot de passe\n");
      out.write("                      </label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"collapse\" id=\"collapseExample\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                        <div class=\"col-sm-12\">\n");
      out.write("                          <input type=\"text\" placeholder=\"password\" id=\"link_password\" name=\"link_password\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                  <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-default\">Raccourcir</button>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </form>\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("          ");
 if(breizhLink != null) { 
      out.write("\n");
      out.write("          <div class=\"col-xs-12\">\n");
      out.write("            <div class=\"form-horizontal\" >\n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                <label for=\"link_url\" class=\"col-sm-2 control-label\">Votre url raccourcie</label>\n");
      out.write("                <div class=\"col-sm-10\">\n");
      out.write("                  <input type=\"text\" class=\"form-control\" value=\"http://localhost:8080/breizh/");
      out.print( breizhLink.getShortUrl());
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("          ");
 if(user == null) { 
      out.write("\n");
      out.write("          <div class=\"col-xs-12\">\n");
      out.write("            <h5><a href=\"register\">Créer un compte pour voir nos autres options possibles</a></h5>\n");
      out.write("          </div>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}