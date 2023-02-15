<%@include file="pageConstructor/header.jsp" %>
My Profile
<br>
<br>
Your name: ${sessionScope.user.getUserName()}
<br>
Your Role: ${sessionScope.user.getRole()}
<br>
Your count of game: ${sessionScope.user.getGameList().size()}
<br>
<br>
<a href="userChangeProfile">Change your profile</a>
    <br>
    <br>
    <c:if test="${sessionScope.isAdmin}">
    <a href="adminMenu">to Admin Panel</a>
    </c:if>
    <br>
    <br>

    <h3>Your wall with posts</h3>
    ${requestScope.userWall}
    <br>

    <form class="form-horizontal" action="profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>New Post</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="postInput">Write text of post</label>
                <div class="col-md-4">
                    <input id="postInput" name="postInput" type="text" placeholder="Text of Post"
                           class="form-control input-md">

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


<%@include file="pageConstructor/footer.jsp" %>