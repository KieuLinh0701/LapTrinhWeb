<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- BEGIN CONTENT -->
<div class="col-md-12 col-sm-12">
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<c:if test="${alert !=null}">
					<h3 class="alert alertdanger">${alert}</h3>
				</c:if>
				<form action="${pageContext.request.contextPath}/editaccount" method="post" enctype="multipart/form-data" class="form-horizontal form-without-legend" role="form">
					<input type="hidden" name="username" value="${sessionScope.account.username}">
					<div class="form-group">
						<label for="fullname" class="col-lg-4 control-label">Full Name <span
							class="require">*</span></label>
						<div class="col-lg-8">
							<input type="text" class="form-control" id="fullname" name="fullname" value="${sessionScope.account.fullname}">
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-lg-4 control-label">Phone
							<span class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="text" class="form-control" id="phone" name="phone" value="${sessionScope.account.phone}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="file" class="col-lg-4 control-label">File <span
							class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="file" class="form-control" id="file" name="file">
							<p id="currentFileName">${sessionScope.account.images}</p>
						</div>
					</div>
					
					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
							<button type="submit" class="btn btn-primary">Change Information</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4 col-sm-4 pull-right">
				<div class="form-info">
					<h2>
						<em>Important</em> Information
					</h2>
					<p>Duis autem vel eum iriure at dolor vulputate velit esse vel
						molestie at dolore.</p>

					<button type="button" class="btn btn-default">More details</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END CONTENT -->