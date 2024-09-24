<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!-- BEGIN CONTENT -->
<div class="col-md-12 col-sm-12">
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<c:if test="${alert !=null}">
					<h3 class="alert alertdanger">${alert}</h3>
				</c:if>
				<form action="${pageContext.request.contextPath}/forgotpassword" method="post" class="form-horizontal form-without-legend" role="form">
					<div class="form-group">
						<label for="username" class="col-lg-4 control-label">User Name <span
							class="require">*</span></label>
						<div class="col-lg-8">
							<input type="text" class="form-control" id="username" name="username" require>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-lg-4 control-label">Password
							<span class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="password" class="form-control" id="password" name="password">
						</div>
					</div>
					<div class="form-group">
						<label for="repeatPassword" class="col-lg-4 control-label">Confirm Password
							<span class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="password" class="form-control" id="repeatPassword" name="repeatPassword">
						</div>
					</div>
					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
							<button type="submit" class="btn btn-primary">Submit</button>
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
