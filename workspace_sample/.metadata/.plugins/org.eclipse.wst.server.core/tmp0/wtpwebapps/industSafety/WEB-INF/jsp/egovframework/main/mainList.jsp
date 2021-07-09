<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : egovSampleList.jsp
  * @Description : Sample List 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2009.02.01            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.02.01
  *
  * Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><spring:message code="title.sample" /></title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
    <script type="text/javaScript" language="javascript">
    	
    $(function(){
    	var ctx = document.getElementById("myChart").getContext('2d');
	    /*
	    - Chart를 생성하면서, 
	    - ctx를 첫번째 argument로 넘겨주고, 
	    - 두번째 argument로 그림을 그릴때 필요한 요소들을 모두 넘겨줍니다. 
	    */
	    
	    var myChart = new Chart(ctx, {
	        type: 'bar',
	        data: {
	            labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange", "Black"],
	            datasets: [{
	                label: '# of Votes',
	                data: [12, 19, 3, 5, 2, 3, 10],
	                backgroundColor: [
	                    'rgba(255, 99, 132, 0.2)',
	                    'rgba(54, 162, 235, 0.2)',
	                    'rgba(255, 206, 86, 0.2)',
	                    'rgba(75, 192, 192, 0.2)',
	                    'rgba(153, 102, 255, 0.2)',
	                    'rgba(255, 159, 64, 0.2)',
	                    'rgba(0, 0, 0, 0.2)'
	                ],
	                borderColor: [
	                    'rgba(255,99,132,1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)',
	                    'rgba(0, 0, 0, 1)'
	                ],
	                borderWidth: 1
	            }]
	        },
	        options: {
	            maintainAspectRatio: true, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
	            scales: {
	                yAxes: [{
	                    ticks: {
	                        beginAtZero:true
	                    }
	                }]
	            }
	        }
	    });
    });
		    
    </script>
</head>

<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
    <form:form commandName="searchVO" id="listForm" name="listForm" method="post">
        <input type="hidden" name="selectedId" />
        <div id="content_pop">
        	<!-- 타이틀 -->
        	
        	<!-- // 타이틀 -->
        	<%-- <div id="search">
        		<ul>
        			<li>
        			    <label for="searchCondition" style="visibility:hidden;"><spring:message code="search.choose" /></label>
        				<form:select path="searchCondition" cssClass="use">
        					<form:option value="1" label="Name" />
        					<form:option value="0" label="ID" />
        				</form:select>
        			</li>
        			<li><label for="searchKeyword" style="visibility:hidden;display:none;"><spring:message code="search.keyword" /></label>
                        <form:input path="searchKeyword" cssClass="txt"/>
                    </li>
        			<li>
        	            <span class="btn_blue_l">
        	                <a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a>
        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
        	            </span>
        	        </li>
                </ul>
        	</div> --%>
        	<!-- List -->
        	<div style="width:80%">
			    <canvas id="myChart"></canvas>
			</div>
			
			<div id="title">
        		<ul>
        			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>실시간 데이터</li>
        		</ul>
        	</div>
        	<div id="table">
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
        			<caption style="visibility:hidden">카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블</caption>
        			<colgroup>
        				<col width="10%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        			</colgroup>
        			<tr>
        				<th align="center">co2</th>
        				<th align="center">온도</th>
        				<th align="center">습도</th>
        				<th align="center">심박수</th>
        				<th align="center">활동량</th>
        				<th align="center">미세먼지</th>
        				<th align="center">유해가스</th>
        				<th align="center">발생시간</th>
        			</tr>
        			<c:forEach var="result" items="${resultList}" varStatus="status">
            			<tr>
            				<td align="center" class="listtd"><c:out value="${result.co2}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.temp}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.humidity}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.heartRate}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.activity}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.dust}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.harmfulGas}"/>&nbsp;</td>
            				<td align="center" class="listtd"><c:out value="${result.updateDate}"/>&nbsp;</td>
            			</tr>
        			</c:forEach>
        		</table>
        	</div>
        	<!-- /List -->
        	<%-- <div id="paging">
        		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
        		<form:hidden path="pageIndex" />
        	</div>
        	<div id="sysbtn">
        	  <ul>
        	      <li>
        	          <span class="btn_blue_l">
        	              <a href="javascript:fn_egov_addView();"><spring:message code="button.create" /></a>
                          <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                      </span>
                  </li>
              </ul>
        	</div> --%>
        </div>
    </form:form>
</body>
</html>
