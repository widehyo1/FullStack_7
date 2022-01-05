<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Project Management System - probada</title>
    <link
      rel="icon"
      href="/webapp/resources/asserts//webapp/resources/asserts/images/tab-img.jpg"
    />

    <!-- Bootstrap -->
    <link
      href="/webapp/resources/bootstrap/vendors/bootstrap/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Font Awesome -->
    <link
      href="/webapp/resources/bootstrap/vendors/font-awesome/css/font-awesome.min.css"
      rel="stylesheet"
    />
    <!-- NProgress -->
    <link
      href="/webapp/resources/bootstrap/vendors/nprogress/nprogress.css"
      rel="stylesheet"
    />
    <!-- iCheck -->
    <link
      href="/webapp/resources/bootstrap/vendors/iCheck/skins/flat/green.css"
      rel="stylesheet"
    />
    <!-- Custom Theme Style -->
    <link
      href="/webapp/resources/bootstrap/build/css/custom.min.css"
      rel="stylesheet"
    />
    <!-- Datatables -->
    <link
      href="/webapp/resources/bootstrap/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="/webapp/resources/bootstrap/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="/webapp/resources/bootstrap/vendors/datatables.net-fixeheader-bs/css/fixedHeader.bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="/webapp/resources/bootstrap/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="/webapp/resources/bootstrap/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- include -->
    <script src="../test-js/includeHTML.js"></script>

    <!-- project datatable 관련 css -->
    <style>
      .project-name {
        color: black;
      }
       #example_wrapper .row:first-child{
        display: flex;
        justify-content: end;
      }
      #example_filter {
        display: flex;
      }
      select#select{
        margin-right: 15px;
      }
      div#example_length {
        margin-right: 15px;
    } */
    </style>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0">
              <a href="index.html" class="site_title"
                ><img
                  src="https://img.icons8.com/ios-filled/35/ffffff/lighthouse.png"
                />
                <span>I prodaba YOU!</span></a
              >
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img
                  src="/webapp/resources/asserts/images/img.jpg"
                  alt="..."
                  class="img-circle profile_img"
                />
              </div>
              <div class="profile_info">
                <span>환영합니다,</span>
                <h2>홍길동</h2>
              </div>
              <div class="clearfix"></div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div
              id="sidebar-menu"
              class="main_menu_side hidden-print main_menu"
            >
              <div class="menu_section">
                <ul class="nav side-menu">
                  <li>
                    <a href="#"><i class="fa fa-dash-board"></i> 홈</a>
                  </li>
                  <li>
                    <a><i class="fa fa-edit"></i> 프로젝트 </a>
                  </li>
                  <li>
                    <a><i class="fa fa-desktop"></i> 프로젝트</a>
                  </li>
                  <li>
                    <a><i class="fa fa-code-fork"></i> 콜라보</a>
                  </li>
                </ul>
              </div>

              <div class="menu_section">
                <h3>내 프로젝트</h3>
                <ul class="nav side-menu">
                  <li>
                    <a
                      ><i class="fa fa-user"></i> 개인
                      <span class="fa fa-chevron-down"></span
                    ></a>
                    <ul class="nav child_menu">
                      <!-- 리스트 추가 -->
                      <li>
                        <a href="general_elements.html"
                          >남양(주) 사이트 유지보수</a
                        >
                      </li>
                      <li>
                        <a href="media_gallery.html">테슬라 자율주행 렌더링</a>
                      </li>
                      <li>
                        <a href="typography.html">현대자동차 베터리 용접</a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a
                      ><i class="fa fa-group"></i> 그룹
                      <span class="fa fa-chevron-down"></span
                    ></a>
                    <ul class="nav child_menu">
                      <!-- 리스트 추가 -->
                      <li>
                        <a href="general_elements.html"
                          >구글 자연어 DB 프로젝트</a
                        >
                      </li>
                      <li>
                        <a href="media_gallery.html"
                          >테슬라 공식홈페이지 개편</a
                        >
                      </li>
                      <li>
                        <a href="typography.html">대한항공 키오스크 보수</a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a
                      ><i class="fa fa-sitemap"></i> 콜라보
                      <span class="fa fa-chevron-down"></span
                    ></a>
                    <ul class="nav child_menu">
                      <li><a href="#level1_1">마케팅&홍보 프로젝트</a></li>
                      <li>
                        <a
                          >대한항공 키오스크 보수<span
                            class="fa fa-chevron-down"
                          ></span
                        ></a>
                        <ul class="nav child_menu">
                          <li class="sub_menu">
                            <a href="level2.html">3D 렌더링 프로젝트</a>
                          </li>
                          <li><a href="#level2_1">키오스크 프론트앤드</a></li>
                          <li><a href="#level2_2">키오스크 백앤드</a></li>
                          <li><a href="#level2_3">안내 음성 인식</a></li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="알림설정">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span
                  class="glyphicon glyphicon-fullscreen"
                  aria-hidden="true"
                ></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span
                  class="glyphicon glyphicon-eye-close"
                  aria-hidden="true"
                ></span>
              </a>
              <a
                data-toggle="tooltip"
                data-placement="top"
                title="로그아웃"
                href="login.html"
              >
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>
            <nav class="nav navbar-nav">
              <ul class="navbar-right">
                <div class="search-box">
                  <button class="btn-search">
                    <i class="fa fa-search"></i>
                  </button>
                  <input
                    type="text"
                    class="input-search"
                    placeholder="프로젝트명 또는 닉네임을 입력해주세요..."
                  />
                </div>

                <li
                  role="presentation"
                  class="nav-item dropdown open"
                  style="margin-left: 30px"
                >
                  <a
                    href="javascript:;"
                    class="dropdown-toggle info-number"
                    id="navbarDropdown1"
                    data-toggle="dropdown"
                    aria-expanded="false"
                  >
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
                  <ul
                    class="dropdown-menu list-unstyled msg_list"
                    role="menu"
                    aria-labelledby="navbarDropdown1"
                  >
                    <li class="nav-item">
                      <a class="dropdown-item">
                        <span class="image"
                          ><img
                            src="/webapp/resources/asserts/images/img.jpg"
                            alt="Profile Image"
                        /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie
                          makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li class="nav-item">
                      <a class="dropdown-item">
                        <span class="image"
                          ><img
                            src="/webapp/resources/asserts/images/img.jpg"
                            alt="Profile Image"
                        /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie
                          makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li class="nav-item">
                      <a class="dropdown-item">
                        <span class="image"
                          ><img
                            src="/webapp/resources/asserts/images/img.jpg"
                            alt="Profile Image"
                        /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie
                          makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li class="nav-item">
                      <a class="dropdown-item">
                        <span class="image"
                          ><img
                            src="/webapp/resources/asserts/images/img.jpg"
                            alt="Profile Image"
                        /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie
                          makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li class="nav-item">
                      <div class="text-center">
                        <a class="dropdown-item">
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>

                <li class="nav-item dropdown open" style="padding: 0px 15px">
                  <a
                    href="javascript:;"
                    class="user-profile dropdown-toggle"
                    aria-haspopup="true"
                    id="navbarDropdown"
                    data-toggle="dropdown"
                    aria-expanded="false"
                  >
                    <img
                      src="/webapp/resources/asserts/images/img.jpg"
                      alt=""
                    />홍길동
                  </a>
                  <div
                    class="dropdown-menu dropdown-usermenu pull-right"
                    aria-labelledby="navbarDropdown"
                  >
                    <a class="dropdown-item" href="javascript:;"> 프로필</a>
                    <a class="dropdown-item" href="javascript:;">
                      <span>알림설정</span>
                    </a>
                    <a class="dropdown-item" href="javascript:;">FAQ</a>
                    <a class="dropdown-item" href="login.html"
                      ><i class="fa fa-sign-out pull-right"></i> 로그아웃</a
                    >
                  </div>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- 메에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에에인  -->

        <!-- page content -->
        <div class="right_col" role="main">
          <!-- 내 작업 바디 시작 -->
          <div class="x_panel">
            <div class="x_title">
              <h2>
                <i class="fa fa-edit"></i> 프로젝트
                <small>* 커스터 마이징 해주세요.</small>
              </h2>

              <div class="clearfix"></div>
            </div>

            <div class="x_content">
              <ul class="nav nav-tabs bar_tabs" id="myTab" role="tablist">
                <li class="nav-item">
                  <a
                    class="nav-link active"
                    id="home-tab"
                    data-toggle="tab"
                    href="#home"
                    role="tab"
                    aria-controls="home"
                    aria-selected="true"
                    >프로젝트 리스트</a
                  >
                </li>
              </ul>
              <!-- 테이블 데이터 리스트 -->
              <div class="x_content">
                <div class="row">
                  <div class="col-sm-12">
                    <div class="card-box table-responsive">
                      <p class="text-muted font-13 m-b-30">
                        모든 프로젝트 리스트를 출력합니다.
                      </p>
                      <div id="test-all" class="row">
                      <div id="test" class="row"></div>
                      <div id="test2" class="row" style="display: flexbox;" ></div>
                      </div>
                      <table
                        id="example"
                        class="table table-striped table-bordered"
                        style="width: 100%"
                      ></table>
                    </div>
                  </div>
                </div>
              </div>
              <!-- 리스트 종료 -->
            </div>
          </div>
          <!-- 내 작업 바디 끝 -->
        </div>

        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Copyright © 2022
            <a
              href="<%=request.getContextPath()%>/probada.com/index"
              style="color: #73879c"
              >probada</a
            >
            App Company. All Rights Reserved.
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- include -->
    <script>
      includeHTML();
    </script>
    <!-- jQuery -->
    <script src="/webapp/resources/bootstrap/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/webapp/resources/bootstrap/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="/webapp/resources/bootstrap/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/webapp/resources/bootstrap/vendors/nprogress/nprogress.js"></script>
    <!-- ECharts -->
    <script src="/webapp/resources/bootstrap/vendors/echarts/dist/echarts.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/echarts/map/js/world.js"></script>
    <!-- Datatables -->
    <script src="/webapp/resources/bootstrap/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/jszip/dist/jszip.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/pdfmake/build/vfs_fonts.js"></script>
    <!-- morris.js -->
    <script src="/webapp/resources/bootstrap/vendors/raphael/raphael.min.js"></script>
    <script src="/webapp/resources/bootstrap/vendors/morris.js/morris.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="/webapp/resources/bootstrap/build/js/custom.min.js"></script>

    <!-- dataTable 설정구간 여기에요 -->
    <script>
      // 데이터 입력받는 곳
      var dataSet = [
        [
          '<a class="project-name" href="./my-project.html">남양(주) 사이트 유지보수<a> <i class="fa fa-globe fa-lg"></i>',
          "mimi2022",
          "2011-04-25",
          '<i class="fa fa-spinner fa-pulse"></i> 진행중',
          ],
          [
          '테슬라 자율주행 렌더링 <i class="fa fa-shield fa-lg"></i>',
          "StoneEnergyTA",
          "2021-08-21",
          '<i class="fa fa-check-circle-o fa-lg"></i> 완료',
          ],
          [
          '현대자동차 배터리 용접 <i class="fa fa-lock fa-lg"></i>',
          "SpearWaterDA",
          "2020-03-11",
          '<i class="fa fa-spinner fa-pulse"></i> 진행중',
          ],
          [
          '구글 자연어 DB 프로젝트 <i class="fa fa-shield fa-lg"></i>',
          "BronzeRootUA",
          "2021-01-07",
          '<i class="fa fa fa-exclamation-triangle" style="color:red"></i> 파기요청',
          ],
          [
          '하나은행 공식홈페이지 <i class="fa fa-globe fa-lg"></i>',
          "EnergyWookAA",
          "2020-01-11",
          '<i class="fa fa-spinner fa-pulse"></i> 진행중',
          ],
          [
          '대한항공 키오스크 보수 <i class="fa fa-lock fa-lg"></i>',
          "RealHyeokPL",
          "2021-01-11",
          '<i class="fa fa-spinner fa-pulse"></i> 진행중',
        ],
      ];
      // 컬럼명 입력받는 곳
      var col_title = [
        { title: "프로젝트명" },
        { title: "담당자" },
        { title: "시작일" },
        { title: "진행상태" },
      ];

      // 소트용 데이터
      var sort_data = [
        { title: '진행상태'},
        { title: '진행중' },
        { title: "파기요청" },
        { title: "완료" },
      ];
      // Korean
      var lang_kor = {
        decimal: "",
        emptyTable: "데이터가 없습니다.",
        info: "_START_ - _END_ (총 _TOTAL_ 개)",
        infoEmpty: "0개",
        infoFiltered: "(전체 _MAX_ 개 중 검색결과)",
        infoPostFix: "",
        thousands: ",",
        lengthMenu: "_MENU_ 개씩 보기",
        loadingRecords: "로딩중...",
        processing: "처리중...",
        search: "검색 : ",
        zeroRecords: "검색된 데이터가 없습니다.",
        paginate: {
          first: "첫 페이지",
          last: "마지막 페이지",
          next: "다음",
          previous: "이전",
        },
        aria: {
          sortAscending: " :  오름차순 정렬",
          sortDescending: " :  내림차순 정렬",
        },
      };

      $(document).ready(function () {
        var table = $("#example").DataTable({
          data: dataSet,
          columns: col_title,
          language: lang_kor,
          dom: 'B<"clear">lfrtip',
          buttons: [
          "pdf",
          "copy",
          "excel",
          {
            text: "프로젝트 추가",
            action: function () {
              alert("추가 페이지로 이동");
            },
          },
          ]
        });

        table.buttons().container().appendTo($('#test'));
        $('#example_length').appendTo($('#test'));
        $('#example_filter').appendTo($('#test'));
        /* Column별 검색기능 추가 */ 
        $('.dataTables_wrapper .row div').removeClass('col-sm-6').addClass('filter-bar-probada')
        $("#example_filter").prepend(
        '<select id="select" name="status" class="form-control input-lg dataTables_filter"></select>'
        );
        $.each(sort_data, function (index, item) {
          $("#select").append("<option name='option_status'>" + item.title + "</option>");
        });

         $('#select').on('change', function () {
          var colName = $('#select option:selected').val();
          table.column(3).search(colName).draw();
          if(colName=="진행상황") table.column().search().draw();
        }); 
    
      });
    </script>
  </body>
</html>