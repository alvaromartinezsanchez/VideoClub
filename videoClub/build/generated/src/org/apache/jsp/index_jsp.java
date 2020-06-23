package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.lang.NullPointerException;
import java.util.*;
import java.sql.*;
import Servlets.*;
import jspTag.*;
import conexion.ConnexionMySQL;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body { background-image: url(./img/fondo.jpg); }\n");
      out.write("        header{ background-color: black; color: white; border-radius: 10px; border: 1px solid grey; margin-top: 5px; margin-bottom: 45px; padding:15px; text-align: center;}\n");
      out.write("        h4{color:white;}\n");
      out.write("        .btn:hover{ background: dimgrey; color:white;}\n");
      out.write("        .btn{color:white; background: black;}\n");
      out.write("        footer{ color:white; background:#272b273a;}\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            ArrayList<pelicula> datosPelicula = new ArrayList<>();
            request.setCharacterEncoding("UTF-8");
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ConnexionMySQL cn = new ConnexionMySQL();
                cn.obtenerConexion();
                datosPelicula = cn.listarPeliculasInicio();
                request.setAttribute("lasPeliculas", datosPelicula);
                //Preparamos para enviar a Inicio.jsp
                RequestDispatcher myDispatcher = request.getRequestDispatcher("./index.jsp");
                //Envio
                myDispatcher.forward(request, response);
                cn.desconectar();
            } catch (Exception e) {
                out.println("Fallo en el listado-->" + e);
            }
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <header class=\"row justify-content-center\">\n");
      out.write("\n");
      out.write("                <!--TITULO-->\n");
      out.write("                <div class=\"col-10\">\n");
      out.write("                    <h2 class=\"text-center\">VideClub-VM</h2>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!--BARRA DE MENU-->\n");
      out.write("\n");
      out.write("                <ul class=\"nav nav-pills nav-fill\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn col\" href=\"index2.jsp\"  role=\"button\"  class=\"nav-link active\">Iniciar Sesion</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn col\" href=\"registrarUsuarios.jsp\"  role=\"button\" >Registro Usuario</a>\n");
      out.write("                    </li>\n");
      out.write("                   \n");
      out.write("                </ul>\n");
      out.write("            </header>\n");
      out.write("            <section>\n");
      out.write("\n");
      out.write("                <article class=\"row justify-content-center\">\n");
      out.write("                    <h4 class=\"col-12\">Peliculas con mayor descuento:</h4>\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </article>  \n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <footer class=\"row justify-content-around align-item-center\">\n");
      out.write("                <div class=\"col-6 col-md-8 align-self-center\">\n");
      out.write("                    <div class=\"row align-item-center\">\n");
      out.write("                        <img src=\"./img/logo.png\" class=\"col-6 col-sm-4 col-md-2\" style=\"width:50px; height: 50px;\" alt=\"\">\n");
      out.write("                        <h5 class=\"d-none d-md-block col-10 align-self-end\">Derechos reservados © Ces-VegaMedia</h5>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-6 col-md-3 align-self-center\">\n");
      out.write("                    <div class=\"row justify-content-center align-item-center p-1\">\n");
      out.write("                        <a href=\"\" ><img class=\"col-12\" style=\"width:100%; height: 100%;\" src=\"./img/facebook.png\" alt=\"\"></a>\n");
      out.write("                        <a href=\"\" ><img class=\"col-12\" src=\"./img/twitte.jpg\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("PeliculasTemp");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lasPeliculas}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\n");
          out.write("                        <img class=\"col-2 m-4 \" src=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PeliculasTemp.getImagen()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(";> \n");
          out.write("\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
