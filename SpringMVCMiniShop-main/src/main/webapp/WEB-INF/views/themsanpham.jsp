<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
-->
<!DOCTYPE HTML>
<html>

<head>
    <title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Home :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css" />' type='text/css' />
    <!-- Custom CSS -->
    <link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' type='text/css' />
    <link rel="stylesheet" href='<c:url value="/resources/css/morris.css" />' type='text/css' />
    <link rel="stylesheet" href='<c:url value="/resources/styles/styles.css" />' type='text/css' />
    <!-- Graph CSS -->
    <link rel="stylesheet" href='<c:url value="/resources/css/font-awesome.css" />' type='text/css' />
    <!-- jQuery -->
    <script src='<c:url value="/resources/js/jquery-3.3.1.min.js" />'></script>
    <!-- //jQuery -->
    <link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css' />
    <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- lined-icons -->
    <link rel="stylesheet" href='<c:url value="/resources/css/icon-font.min.css" />' type='text/css' />
    <!-- //lined-icons -->
</head>

<body>
    <div class="page-container">
        <!--/content-inner-->
        <div class="left-content">
            <h3>San pham</h3>
            <div class="row">
                <form action="" id="form-sanpham">
                    <div class="col-md-6 col-sm-12 form-group">
                        <label for="tenSanPham">ten san pham</label>
                        <input type="text" id="tenSanPham" name="tenSanPham" class="form-control" value="" placeholder="Nhap vao ten san pham">
                        <br>

                        <label for="giaTien">Gia tien</label>
                        <input type="text" id="giaTien" name="giaTien" class="form-control" value="" placeholder="Nhap vao gia tien">
                        <br>

                        <label for="danhMucSanPham">Select list:</label>
                        <select class="form-control" id="danhMucSanPham" name="danhMucSanPham">
                            <c:forEach var="valdanhmuc" items="${danhMucs}">
                                <option value="${valdanhmuc.getMadanhmuc()}"> ${valdanhmuc.getTendanhmuc()}</option>
                            </c:forEach>
                        </select>
                        <br>

                        <label for="moTa">Mo Ta</label>
                        <textarea id="moTa" rows="5" name="moTa" class="form-control" placeholder="Them mo ta"></textarea>

                        <label for="hinhSanPham">Hinh anh</label>
                        <input type="file" id="hinhSanPham" name="hinhSanPham" class="form-control-file" value="" placeholder="Nhap vao gia tien">
                        <br>

                        <span>Gianh cho</span>
                        <br>
                        <label class="radio-inline">
                            <input type="radio" id="rd-nam" name="gianhCho" value="nam" checked>Nam
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="rd-nu" name="gianhCho" value="nu">Nu
                        </label>
                        <br>
                </form>

                <div class="chitietsanpham" id="chitietsanpham">
                    <span>Chi tiet</span>
                    <br>

                    <select class="form-control" id="mau" name="mau">
                        <c:forEach var="valmau" items="${mauSanPhams}">
                            <option value="${valmau.getMamau()}"> ${valmau.getTenmau()}</option>
                        </c:forEach>
                    </select>
                    <br>

                    <select class="form-control" id="size" name="size">
                        <c:forEach var="valsize" items="${sizeSanPhams}">
                            <option value="${valsize.getMasize()}"> ${valsize.getSize()}</option>
                        </c:forEach>
                    </select>
                    <br>

                    <label for="soluong">So luong</label>

                    <input min="1" type="number" id="soluong" name="soluong" class="form-control" value="1" placeholder="Nhap so luong">
                    <br>
                    <button class="btn btn-default btn-chitiet">them chi tiet</button>
                </div>

                <div id="container-chitietsanpham">
                    <div class="chitietsanpham">
                        <span>Chi tiet</span>
                        <br>

                        <select class="form-control" id="mau" name="mau">
                            <c:forEach var="valmau" items="${mauSanPhams}">
                                <option value="${valmau.getMamau()}"> ${valmau.getTenmau()}</option>
                            </c:forEach>
                        </select>
                        <br>

                        <select class="form-control" id="size" name="size">
                            <c:forEach var="valsize" items="${sizeSanPhams}">
                                <option value="${valsize.getMasize()}"> ${valsize.getSize()}</option>
                            </c:forEach>
                        </select>
                        <br>

                        <label for="soluong">So luong</label>
                        <input min="1" type="number" id="soluong" name="soluong" class="form-control" value="1" placeholder="Nhap so luong">
                        <br>

                        <button class="btn btn-default btn-chitiet">them chi tiet</button>

                    </div>
                </div>

                <button id="btn-themsanpham" class="btn btn-primary">them san pham</button>

                </div>
                <div class="col-md-6 col-sm-12">
                    <div style="float: right;">
                        <button id="xoa-sanpham" class="btn btn-danger">xoa</button>
                    </div>
                    <table id="table-sanpham" class="table">
                        <thead>
                            <tr>
                                <td>
                                    <div class="checkbox">
                                        <label>
                                            <input id="check-all" type="checkbox" value="">
                                        </label>
                                    </div>
                                </td>
                                <td>T??n s???n ph???m</td>
                                <td>Gi?? ti???n</td>
                                <td>Gi??nh cho</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="value" items="${ lstsp }">
                                <tr>
                                    <td>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" class="checkboxsanpham" value="${ value.getMasanpham()}">
                                            </label>
                                        </div>
                                    </td>
                                    <td class="tensp" data-masp="${ value.getMasanpham()}"> ${ value.getTensanpham() }</td>
                                    <td class="giatien" data-value="${value.getGiatien()}">${value.getGiatien()}</td>
                                    <td class="gianhcho" data-value="${value.getGianhcho()}">${value.getGianhcho()}</td>
                                    <td class="btn btn-warning capnhatsanpham" data-id="${ value.getMasanpham()}">Sua</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <ul class="pagination">
                        <c:forEach var="i" begin="1" end="${tongSp}">
                            <c:choose>
                                <c:when test="${i == 1}">
                                    <li class="paging-item active">
                                        <a href="#">${i}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a href="#">${i}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ul>
                </div>


            </div>
        </div>
        <!--//content-inner-->
        <!--/sidebar-menu-->
        <div class="sidebar-menu">
            <header class="logo1">
                <a href="#" class="sidebar-icon">
                    <span class="fa fa-bars"></span>
                </a>
            </header>
            <div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
            <div class="menu">
                <ul id="menu">
                    <li>
                        <a href="index.html">
                            <i class="fa fa-tachometer"></i>
                            <span>Dashboard</span>
                            <div class="clearfix"></div>
                        </a>
                    </li>


                    <li id="menu-academico">
                        <a href="<c:url value=" /themsanpham "/>">
                            <i class="fa fa-envelope nav_icon"></i>
                            <span>S???n ph???m</span>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                    <li>
                        <a href="gallery.html">
                            <i class="fa fa-picture-o" aria-hidden="true"></i>
                            <span>Gallery</span>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                    <li id="menu-academico">
                        <a href="charts.html">
                            <i class="fa fa-bar-chart"></i>
                            <span>Charts</span>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                    <li id="menu-academico">
                        <a href="#">
                            <i class="fa fa-list-ul" aria-hidden="true"></i>
                            <span> Short Codes</span>
                            <span class="fa fa-angle-right" style="float: right"></span>
                            <div class="clearfix"></div>
                        </a>
                        <ul id="menu-academico-sub">
                            <li id="menu-academico-avaliacoes">
                                <a href="icons.html">Icons</a>
                            </li>
                            <li id="menu-academico-avaliacoes">
                                <a href="typography.html">Typography</a>
                            </li>
                            <li id="menu-academico-avaliacoes">
                                <a href="faq.html">Faq</a>
                            </li>
                        </ul>
                    </li>
                    <li id="menu-academico">
                        <a href="errorpage.html">
                            <i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
                            <span>Error Page</span>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                    <li id="menu-academico">
                        <a href="#">
                            <i class="fa fa-cogs" aria-hidden="true"></i>
                            <span> UI Components</span>
                            <span class="fa fa-angle-right" style="float: right"></span>
                            <div class="clearfix"></div>
                        </a>
                        <ul id="menu-academico-sub">
                            <li id="menu-academico-avaliacoes">
                                <a href="button.html">Buttons</a>
                            </li>
                            <li id="menu-academico-avaliacoes">
                                <a href="grid.html">Grids</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="tabels.html">
                            <i class="fa fa-table"></i>
                            <span>Tables</span>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                    <li>
                        <a href="maps.html">
                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                            <span>Maps</span>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                    <li id="menu-academico">
                        <a href="#">
                            <i class="fa fa-file-text-o"></i>
                            <span>Pages</span>
                            <span class="fa fa-angle-right" style="float: right"></span>
                            <div class="clearfix"></div>
                        </a>
                        <ul id="menu-academico-sub">
                            <li id="menu-academico-boletim">
                                <a href="calendar.html">Calendar</a>
                            </li>
                            <li id="menu-academico-avaliacoes">
                                <a href="signin.html">Sign In</a>
                            </li>
                            <li id="menu-academico-avaliacoes">
                                <a href="signup.html">Sign Up</a>
                            </li>


                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-check-square-o nav_icon"></i>
                            <span>Forms</span>
                            <span class="fa fa-angle-right" style="float: right"></span>
                            <div class="clearfix"></div>
                        </a>
                        <ul>
                            <li>
                                <a href="input.html"> Input</a>
                            </li>
                            <li>
                                <a href="validation.html">Validation</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
    <script>
        var toggle = true;

        $(".sidebar-icon").click(function () {
            if (toggle) {
                $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
                $("#menu span").css({ "position": "absolute" });
            }
            else {
                $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
                setTimeout(function () {
                    $("#menu span").css({ "position": "relative" });
                }, 400);
            }

            toggle = !toggle;
        });
    </script>

    <!--js -->
    <script src='<c:url value="/resources/js/custom.js" />'></script>
    <script src='<c:url value="/resources/js/jquery.nicescroll.js" />'></script>
    <script src='<c:url value="/resources/js/scripts.js" />'></script>
    <!-- Bootstrap Core JavaScript -->
    <script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
    <!-- /Bootstrap Core JavaScript -->
    <!-- morris JavaScript -->
    <script src='<c:url value="/resources/js/raphael-min.js" />'></script>
    <script src='<c:url value="/resources/js/morris.js" />'></script>

    <script>
        $(document).ready(function () {
            //BOX BUTTON SHOW AND CLOSE
            jQuery('.small-graph-box').hover(function () {
                jQuery(this).find('.box-button').fadeIn('fast');
            }, function () {
                jQuery(this).find('.box-button').fadeOut('fast');
            });
            jQuery('.small-graph-box .box-close').click(function () {
                jQuery(this).closest('.small-graph-box').fadeOut(200);
                return false;
            });

            //CHARTS
            function gd(year, day, month) {
                return new Date(year, month - 1, day).getTime();
            }

            graphArea2 = Morris.Area({
                element: 'hero-area',
                padding: 10,
                behaveLikeLine: true,
                gridEnabled: false,
                gridLineColor: '#dddddd',
                axes: true,
                resize: true,
                smooth: true,
                pointSize: 0,
                lineWidth: 0,
                fillOpacity: 0.85,
                data: [
                    { period: '2014 Q1', iphone: 2668, ipad: null, itouch: 2649 },
                    { period: '2014 Q2', iphone: 15780, ipad: 13799, itouch: 12051 },
                    { period: '2014 Q3', iphone: 12920, ipad: 10975, itouch: 9910 },
                    { period: '2014 Q4', iphone: 8770, ipad: 6600, itouch: 6695 },
                    { period: '2015 Q1', iphone: 10820, ipad: 10924, itouch: 12300 },
                    { period: '2015 Q2', iphone: 9680, ipad: 9010, itouch: 7891 },
                    { period: '2015 Q3', iphone: 4830, ipad: 3805, itouch: 1598 },
                    { period: '2015 Q4', iphone: 15083, ipad: 8977, itouch: 5185 },
                    { period: '2016 Q1', iphone: 10697, ipad: 4470, itouch: 2038 },
                    { period: '2016 Q2', iphone: 8442, ipad: 5723, itouch: 1801 }
                ],
                lineColors: ['#ff4a43', '#a2d200', '#22beef'],
                xkey: 'period',
                redraw: true,
                ykeys: ['iphone', 'ipad', 'itouch'],
                labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
                pointSize: 2,
                hideHover: 'auto',
                resize: true
            });


        });
    </script>
</body>

</html>