<%--
  Created by IntelliJ IDEA.
  User: Takay
  Date: 6/23/2018
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left-sidebar">
    <!-- Sidebar scroll-->
    <div class="scroll-sidebar">
        <!-- Sidebar navigation-->
        <nav class="sidebar-nav">
            <ul id="sidebarnav">
                <li class="nav-devider"></li>
                <li class="nav-label">Home</li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-tachometer"></i><span class="hide-menu">Dashboard <span class="label label-rouded label-primary pull-right">2</span></span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="index.jsp">Ecommerce </a></li>
                        <li><a href="index1.html">Analytics </a></li>
                    </ul>
                </li>
                <li class="nav-label">商品</li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-envelope"></i><span class="hide-menu">书籍</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="/admin/book/table">书籍列表</a></li>
                        <li><a href="/admin/book/create">添加书籍</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-bar-chart"></i><span class="hide-menu">分类</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="/admin/category/table">分类列表</a></li>
                        <li><a href="/admin/category/create">添加分类</a></li>
                    </ul>
                </li>
                <li class="nav-label">Features</li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-suitcase"></i><span class="hide-menu">Bootstrap UI <span class="label label-rouded label-warning pull-right">6</span></span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="ui-alert.html">Alert</a></li>
                        <li><a href="ui-button.html">Button</a></li>
                        <li><a href="ui-dropdown.html">Dropdown</a></li>
                        <li><a href="ui-progressbar.html">Progressbar</a></li>
                        <li><a href="ui-tab.html">Tab</a></li>
                        <li><a href="ui-typography.html">Typography</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-suitcase"></i><span class="hide-menu">Components <span class="label label-rouded label-danger pull-right">6</span></span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="uc-calender.html">Calender</a></li>
                        <li><a href="uc-datamap.html">Datamap</a></li>
                        <li><a href="uc-nestedable.html">Nestedable</a></li>
                        <li><a href="uc-sweetalert.html">Sweetalert</a></li>
                        <li><a href="uc-toastr.html">Toastr</a></li>
                        <li><a href="uc-weather.html">Weather</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-wpforms"></i><span class="hide-menu">Forms</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="form-basic.html">Basic Forms</a></li>
                        <li><a href="form-layout.html">Form Layout</a></li>
                        <li><a href="form-validation.html">Form Validation</a></li>
                        <li><a href="form-editor.html">Editor</a></li>
                        <li><a href="form-dropzone.html">Dropzone</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-table"></i><span class="hide-menu">Tables</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="table-bootstrap.html">Basic Tables</a></li>
                        <li><a href="table-datatable.html">Data Tables</a></li>
                    </ul>
                </li>
                <li class="nav-label">Layout</li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-columns"></i><span class="hide-menu">Layout</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="layout-blank.html">Blank</a></li>
                        <li><a href="layout-boxed.html">Boxed</a></li>
                        <li><a href="layout-fix-header.html">Fix Header</a></li>
                        <li><a href="layout-fix-sidebar.html">Fix Sidebar</a></li>
                    </ul>
                </li>
                <li class="nav-label">系统</li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-book"></i><span class="hide-menu">账户</span></a>
                    <ul aria-expanded="false" class="collapse">

                        <li><a href="#" class="has-arrow">账户信息 <span class="label label-rounded label-success">6</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="login.jsp">修改密码</a></li>
                                <li><a href="page-register.html">修改头像</a></li>
                            </ul>
                        </li>
                        <li><a href="#" class="has-arrow">Error Pages</a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="page-error-400.html">400</a></li>
                                <li><a href="page-error-403.html">403</a></li>
                                <li><a href="page-error-404.html">404</a></li>
                                <li><a href="page-error-500.html">500</a></li>
                                <li><a href="page-error-503.html">503</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-map-marker"></i><span class="hide-menu">Maps</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="map-google.html">Google</a></li>
                        <li><a href="map-vector.html">Vector</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-level-down"></i><span class="hide-menu">Multi level dd</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="#">item 1.1</a></li>
                        <li><a href="#">item 1.2</a></li>
                        <li> <a class="has-arrow" href="#" aria-expanded="false">Menu 1.3</a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="#">item 1.3.1</a></li>
                                <li><a href="#">item 1.3.2</a></li>
                                <li><a href="#">item 1.3.3</a></li>
                                <li><a href="#">item 1.3.4</a></li>
                            </ul>
                        </li>
                        <li><a href="#">item 1.4</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- End Sidebar navigation -->
    </div>
    <!-- End Sidebar scroll-->
</div>
