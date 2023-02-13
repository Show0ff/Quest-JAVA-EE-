<%@include file="../pageConstructor/header.jsp"%>


${requestScope.userWall}


<form class="form-horizontal" action="wall" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Post</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="postInput">Write text of post</label>
            <div class="col-md-4">
                <input id="postInput" name="postInput" type="text" placeholder="Text of Post" class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="createPost"></label>
            <div class="col-md-4">
                <button id="createPost" name="createPost" class="btn btn-primary">Publish a post</button>
            </div>
        </div>

    </fieldset>
</form>



<%@include file="../pageConstructor/footer.jsp"%>