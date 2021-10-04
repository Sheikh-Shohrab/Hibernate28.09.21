
<!-- GLOBAL HEADER -->
<jsp:include page="common/header.jsp" />


<!-- COURSE COVER IMAGE -->
<img src="${pageContext.request.contextPath }/images/iccCover.jpg" height="500px" class="w-100" />


<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

	<div class="row">

		<!-- HOMEWORK COLUMN-->
		<div class="col">
			<h3 class="p-3"><u>Menue</u></h3>

			<div class="row">
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Countries</h4>
							<p class="card-text">
								<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/country/add"
									role="button">ADD COUNTRY</a> <a
									class="btn btn-primary btn-lg btn-block"
									href="${pageContext.request.contextPath }/country/show-all" role="button">SHOW COUNTRY</a>
							</p>
						</div>
					</div>
				</div>
				
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Users</h4>
							<p class="card-text">
								<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/user/add"
									role="button">ADD USER</a> <a
									class="btn btn-primary btn-lg btn-block"
									href="${pageContext.request.contextPath }/user/show-all" role="button">SHOW USERS</a>
							</p>
						</div>
					</div>
				</div>
				
				
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Team</h4>
							<p class="card-text">
							
							<!-- <form action="course/search" class="mb-5">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Course Name" name="name">
								</div>
								<button type="submit" class="btn btn-primary  btn-lg btn-block">SEARCH</button>
							</form> -->


							<a class="btn btn-success btn-lg btn-block" href="team/add"
								role="button">ADD TEAM</a> <a
								class="btn btn-primary btn-lg btn-block" href="team/show-all"
								role="button">SHOW TEAMS</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Players</h4>
							<p class="card-text">
								<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/player/add"
									role="button">ADD PLAYERS</a> <a
									class="btn btn-primary btn-lg btn-block"
									href="${pageContext.request.contextPath }/player/show-all" role="button">SHOW PLAYERS</a>
							</p>
						</div>
					</div>
				</div>
				

			</div>

		</div>

		<!-- COURSE OUTLINE COLUMN -->
		<div class="col">
			<h3 class="p-3"><u>Venue</u></h3>

			<div class="row">
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<span class="badge badge-success">Dhaka</span>
							<img src="${pageContext.request.contextPath }/images/bangladesh.jpg" height="300px" class="w-100" />
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<span class="badge badge-success">India</span>
							<img src="${pageContext.request.contextPath }/images/india.jpeg" height="300px" class="w-100" />
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<span class="badge badge-info">Australia</span>
							<img src="${pageContext.request.contextPath }/images/melbourne.jpg" height="300px" class="w-100" />

						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="common/footer.jsp" />




