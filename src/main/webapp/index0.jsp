<!DOCTYPE html>
<html>
  <head>
    <title>Post Your Questions</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style3.css">
      <script type="text/javascript" src="scripts/jquery-2.2.3.js"></script>
      <script>
      $(document).ready(function() {

        $("form").submit(function (e) {
          var titleTxt = document.getElementById("posttitle").value;
               var bodyTxt = document.getElementById("postdesc").value;
               var data = JSON.stringify({ title: titleTxt, body: bodyTxt});
               alert( data);

               $.ajax({
                 type : "POST",
                 url : 'cmad/blogs',
                 dataType :"json",
                 contentType: "application/json",
                 data : data,
                 success : function(result) {
                   alert(result.success); // result is an object which is created from the returned JSON
    },

});
      });
      });
      </script>
  </head>

  <body>
    <div id="header">

          <div> <a id="title"href="http://stackoverflow.com/">CMAD Projects</a></div>

        <div id="right"></div>
        <div id="center">
  <a id="login" href="login.html"> login </a>
  <a id="signup" href="signup.html"> sign up </a>
  <input name="q" type="text" placeholder="" value="Search Q&A" tabindex="1" autocomplete="off" maxlength="240">
</div>
      </div>
<!-- Form-->
<div class="box">
  <div class="left">
  <div class="form">
  <div class="form-panel postBlog">
    <div class="form-header">
      <h1>Ask Questions</h1>
    </div>
    <div class="form-content">
      <form>
        <div class="form-group">
          <label>Title</label>
        </div>
    <div class="form-group">
          <input type="text" id="posttitle" name="title" required="required"/>
        </div>
        <div class="form-group">
          <label>Details</label>
        </div>
        <div class="form-group">
          <textarea cols=55 rows=10 id="postdesc" name="body" required="required"></textarea> <br />
        </div>
        <div class="form-group">
          <label class="form-remember">
            <input type="checkbox"/>Send me new responses to my posts via email
        </div>
        <div class="form-group">
          <button id="postblog" type="submit">Post Your Question</button>
        </div>
      </form>
    </div>
  </div>
</div>
</div>
</div>
<div class="right">
    <div class="formques">
  <div class="queslabel">
<h4 >How to Ask</h4>
<pre> Is your question about programming? <br>
We prefer questions that can be answered,
not just discussed.  <br>
Provide details. Share your research.  <br>
If your question is about this website,
<a href="index.html" style="text-decoration: none">ask it on meta instead</a>
</pre>
</div>
</div>
</div>
</div>
</body>
</html>
