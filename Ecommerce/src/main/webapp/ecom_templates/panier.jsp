 <c:if test="${sessionScope.nom != null }">   
						
						<div class="col-md-3 clearfix">
						
                              
                           
							<div class="header-ctn">
								<!-- Wishlist -->
								
								<!-- /Wishlist -->

								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>
										<div class="qty"></div>
									</a>
									
									<div class="cart-dropdown">
										<div class="">
											<c:if test="${sessionScope.prods == null }">
											 <div class="product-body">
													<h3 class="product-name"><a href="#">Y a aucun produit maintenant dans le panier</a></h3>
												</div>
											</c:if>
					            <c:if test="${sessionScope.prods != null }">
											<c:forEach var="p" items="${sessionScope.prods}">
											<div class="product-widget">
												<div class="product-img">
													<img src="data:;base64,${p.photo}" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#">${p.nomProduit }</a></h3>
													<h4 class="product-price"><span class="qty">${p.qte }X</span>${p.puProduit }</h4>
												</div>
												<c:set var="pp" value="${p.nomProduit}" scope="session"/>
											<a href="${pageContext.request.contextPath}/deletElment" class="delete"> <i class="fa fa-close"></i></a>
                           
							
												
											</div>
                                           </c:forEach>
									</c:if>	
										
										</div>
									<div class="cart-summary">
									<c:if test="${sessionScope.prods != null }">
											<c:set var="total" value="${0}"/>
										<c:forEach var="article" items="${sessionScope.prods}">
										    <c:set var="total" value="${total + article.puProduit * article.qte}" />
										</c:forEach>
										<h5>Total : </h5>
										<h5>${total}MAD</h5>
										</c:if>
											
										</div>
										<div class="cart-btns">
									<a href="${pageContext.request.contextPath}/viderPanier">Vider</a>
											
											<a href="${pageContext.request.contextPath}/commande"> commande <i class="fa fa-arrow-circle-right"></i></a>
										</div> 
									</div>
								</div>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
	</c:if>