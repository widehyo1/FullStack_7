<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="" id="inptnt-detail-info-module">
  <div class="inptnt-detail-info">
    <div class="register-card-body" style="padding: 0px;">
      <div class="card" style="padding: 10px;">
        <div class="row">
          <div class="form-group col-lg-4">
            <div class="row">
              <input type="hidden" name="pstiNo" id="pstiNo" value=""> <label for="pstiNm" class="col-sm-5 control-label text-left">성명</label>
            </div>
            <div class="row">
              <div class="col-sm-12" style="padding-left: 5px;">
                <input name="pstiNm" type="text" class="form-control modifyPossible" id="pstiNm" value="" readonly>
              </div>
            </div>
          </div>

          <div class="form-group col-lg-4">
            <div class="row">
              <label for="nlty" class="col-sm-6 control-label text-left" style="padding-top: 0px;">국적</label>
              <div class="col-sm-12">
                <input name="nlty" type="text" class="form-control" id="nlty" value="" readonly>
              </div>
            </div>
          </div>

          <div class="form-group col-lg-4">
            <div class="row">
              <div class="col-lg-6">
                <label for="age" class="col-sm-12 control-label text-left">나이</label>
                <div class="row">
                  <div class="col-sm-12">
                    <input name="age" type="text" class="form-control" id="age" value="" readonly>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <label for="gender" class="col-sm-12 control-label text-left">성별</label>
                <div class="row">
                  <div class="col-sm-12">
                    <input name="gender" type="text" class="form-control" id="gender" value="" readonly>
                  </div>
                </div>
              </div>

            </div>

          </div>
        </div>


        <div class="row">
          <div class="form-group col-lg-4">
            <div class="row">
              <label for="rrn" class="col-sm-12 control-label text-left">주민/외국인등록번호 </label>
            </div>
            <div class="row">
              <div class="col-sm-12" style="padding-left: 5px;">
                <input name="rrn" type="text" class="form-control" id="rrn" value="" readonly>
              </div>
            </div>
          </div>

          <div class="form-group col-lg-4">
            <div class="row">
              <label for="pstiTelno" class="col-sm-4 control-label text-left">연락처</label>
              <div class="col-sm-12">
                <input name="pstiTelno" type="text" class="form-control modifyPossible" id="pstiTelno" value="" readonly>
              </div>
            </div>
          </div>

          <div class="form-group col-lg-4">
            <div class="row">
              <label for="job" class="col-sm-4 control-label text-left">직업</label>
              <div class="col-sm-12">
                <input name="jobCode" type="text" class="form-control" id="job" value="" readonly>
              </div>
            </div>
          </div>

        </div>

        <div class="row">
          <div class="form-group col-lg-12">
            <div class="row">
              <label for="pstiAdres" class="col-sm-12 control-label text-left">주소</label>
            </div>
            <div class="row">
              <div class="col-sm-12" style="padding-left: 5px;">
                <input name="pstiAdres" type="text" class="form-control modifyPossible" id="pstiAdres" value="" readonly>
              </div>
            </div>
          </div>
        </div>
      </div>


      <div class="card" style="padding: 10px;">
        <div class="row">
          <div class="form-group col-lg-3">
            <div class="row">
              <label for="inYmd" class="col-sm-12 control-label text-left">입원일자</label>
            </div>
            <div class="row">
              <div class="col-sm-12" style="padding-left: 5px;">
                <input name="inYmd" type="text" class="form-control" id="inYmd" value="" readonly>
              </div>
            </div>
          </div>

          <div class="form-group col-lg-3">
            <div class="row">
              <label for="critCode" class="col-sm-12 control-label text-left">중증도</label>
              <div class="col-sm-12">
                <input name="critCode" type="text" class="form-control" id="critCode" value="" readonly>
              </div>
            </div>
          </div>


          <div class="form-group col-lg-2">
            <div class="row">
              <label for="ngtvCnt" class="col-sm-12 control-label text-left" style="padding-top: 0px;">누적음성수</label>
              <div class="col-sm-12">
                <input name="ngtvCnt" type="text" class="form-control" id="ngtvCnt" value="" readonly>
              </div>
            </div>
          </div>

          <div class="form-group col-lg-2">
            <div class="row">
              <label for="feverYn" class="col-sm-12 control-label text-left" style="padding-top: 0px;">발열여부</label>
              <div class="col-sm-12">
                <input name="feverYn" type="text" class="form-control" id="feverYn" value="" readonly>
              </div>
            </div>
          </div>
          <div class="form-group col-lg-2">
            <div class="row">
              <label for="pregnYn" class="col-sm-12 control-label text-left" style="padding-top: 0px;">임신여부</label>
              <div class="col-sm-12">
                <input name="pregnYn" type="text" class="form-control" id="pregnYn" value="" readonly>
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-12">
            <div class="row">
              <label for="symptms" class="col-sm-12 control-label text-left">증상</label>
            </div>
            <div class="row">
              <div class="col-sm-12" style="padding-left: 5px;">
                <input name="symptms" type="text" class="form-control modifyPossible" id="symptms" value="" readonly>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <table class="table table-bordered">
      <tbody>
        <tr>
          <td colspan="4" style="padding-bottom: 0px; text-align: center;">
            <div class="form-group row">
              <label for="inputPassword3" class="col-sm-2 control-label text-center" style="padding-top: 7px;">진료 메모</label>
              <div class="col-sm-4"></div>
              <div class="form-group row pr-5 col-sm-6" style="float: right;">
                <button style="background-color: #1a4f72; border-color: #1a4f72; margin-top : 8px;" type="button" id="inptnt-sckbd-req-btn" class="btn btn-block btn-primary btn-sm col-md-5" onclick="OpenWindow('sckbdreq-inptnt', '병원 병상신청', 1250, 800)">이원신청</button>
                <div class="col-md-2" id="inptnt-modify-hidden-div"></div>
                <button style="background-color: #1a4f72; border-color: #1a4f72; margin-top : 8px;" type="button" id="inptnt-modify-btn" class="btn btn-block btn-primary btn-sm col-md-5" onclick="modify();">수정</button>
                <button style="background-color: #1a4f72; border-color: #1a4f72; display: none; margin-top : 8px;" type="button" id="inptnt-save-btn" class="btn btn-block btn-primary btn-sm col-md-5" onclick="save();">저장</button>
                <div class="col-md-2" id="inptnt-modify-cancle-div" style="display : none;"></div>
                <button style="background-color: #1a4f72; border-color: #1a4f72; display: none; margin-top : 8px;" type="button" id="inptnt-cancle-btn" class="btn btn-block btn-primary btn-sm col-md-5" onclick="cancle();">취소</button>
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-12">
                <div style="border: 1px solid #e9e9e9; width: 520px; height: 154px; overFlow: auto; margin-left: 23px;"></div>
              </div>
            </div>

          </td>
        </tr>
      </tbody>
    </table>
  </div>
</div>


