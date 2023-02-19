
<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
					     
						<c:if test="${sessionScope.nom != null }"> 
						<li><a href="#"><i class="fa fa-map-marker"></i>${sessionScope.adresse}</a></li>
						<li><a href="#"><i class=""></i>${sessionScope.nom}${sessionScope.prenom }</a></li>
						
					    </c:if>
					</ul>
					<ul class="header-links pull-right">
						 <c:if test="${sessionScope.nom != null }"> 
						<li><a href="${pageContext.request.contextPath}/logout">logout</a></li>
						</c:if>
						<c:if test="${sessionScope.nom == null }">
						<li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-user-o"></i>login</a></li>
					    </c:if>
					</ul>
				</div>
			</div>