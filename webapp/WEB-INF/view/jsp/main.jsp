<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script>
      $(document).ready(function(){
        $("button[data-role=btnLoadProductUrl]").click(function(){
            var $this = $(this);
            $.ajax({
                type: "post",
                dataType: "json",
                url: "/load/product",
                data: {
                    "url": $this.prev().val()
                },
                success: function(d){
                  $this.next().text(JSON.stringify(d));
                }
            })
        });
      });
    </script>
  </head>
  <body>
    <div class="col-xs-12 col-sm-12 col-md-12">
      제품정보 URL입력 :
      <input type="text" class="form-control input-group" name="productUrl" value="https://www.ikea.com/kr/ko/ideas/201922_idip11a/" />
      <button type="button" class="btn btn-primary" data-role="btnLoadProductUrl">불러오기</button>
      <span id="result1"></span>
    </div>
  </body>
</html>