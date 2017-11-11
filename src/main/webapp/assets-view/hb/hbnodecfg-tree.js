var canshow = true;
!
function(n) {
	var t = function(t, i) {
			this.$element = n(t);
			this.options = n.extend({}, n.fn.tree.defaults, i);
			this.$element.on("click", ".tree-item", n.proxy(function(n) {
				this.selectItem(n.currentTarget)
			}, this));
			this.$element.on("click", ".tree-folder-header", n.proxy(function(n) {
				this.selectFolder(n.currentTarget)
			}, this));
			this.render()
		};
	t.prototype = {
		constructor: t,
		render: function() {
			this.populate(this.$element)
		},
		populate: function(t) {
			var i = this,
				r = t.parent(),
				u = r.find(".tree-loader:eq(0)");
			u.show();
			this.options.dataSource.data(t.data(), function(f) {
				u.hide();
				n.each(f.data, function(u, f) {
					var e, o;
					"folder" === f.type ? (e = i.$element.find(".tree-folder:eq(0)").clone().show(), e.find(".tree-folder-name").html(f.name), e.find(".tree-loader").html(i.options.loadingHTML), e.find(".tree-folder-header").data(f), e.find('[class*="fa-"]').addClass(f["icon-class"])) : "item" === f.type && (e = i.$element.find(".tree-item:eq(0)").clone().show(), e.find(".tree-item-name").html(f.name), e.data(f));
					o = f.dataAttributes || [];
					n.each(o, function(n, t) {
						switch (n) {
						case "class":
						case "classes":
						case "className":
							e.addClass(t);
							break;
						default:
							e.attr(n, t)
						}
					});
					t.hasClass("tree-folder-header") ? r.find(".tree-folder-content:eq(0)").append(e) : t.append(e)
				});
				i.$element.trigger("loaded", r)
			})
		},
		selectItem: function(t) {
			if(!canshow){
				return;
			}
			var i = n(t),
				u = this.$element.find(".tree-selected"),
				r = [],
				f;
			(this.options.multiSelect ? n.each(u, function(t, u) {
				var f = n(u);
				f[0] !== i[0] && r.push(n(u).data())
			}) : u[0] !== i[0] && (u.removeClass("tree-selected").find("i").removeClass("fa fa-check-square-o").addClass("tree-dot"), r.push(i.data())), this.options.selectable) && (f = "selected", i.hasClass("tree-selected") ? (f = "unselected", i.removeClass("tree-selected"), i.find("i").removeClass("fa fa-check-square-o").addClass("tree-dot")) : (i.addClass("tree-selected"), i.find("i").removeClass("tree-dot").addClass("fa fa-check-square-o"), this.options.multiSelect && r.push(i.data())));
			r.length && this.$element.trigger("selected", {
				info: r
			});
			i.trigger("updated", {
				info: r,
				item: i,
				eventType: f
			})
			
			selectTypeId = r[0].typeId;
			selectNodeId = r[0].nodeId;
			tableTypeItem.table.ajax.reload(null, false);
		},
		selectFolder: function(t) {
			if(!canshow){
				return;
			}
			var r, u, f, i = n(t),
				o = i.parent(),
				s = o.find(".tree-folder-content"),
				e = s.eq(0);
			i.find(".fa.fa-folder").length ? (r = "opened", u = ".fa.fa-folder", f = "fa fa-folder-open", e.show(), s.children().length || this.populate(i)) : (r = "closed", u = ".fa.fa-folder-open", f = "fa fa-folder", e.hide(), this.options.cacheItems || e.empty());
			o.find(u).eq(0).removeClass("fa fa-folder fa-folder-open").addClass(f);
			this.$element.trigger(r, i.data())
		},
		selectedItems: function() {
			var i = this.$element.find(".tree-selected"),
				t = [];
			return n.each(i, function(i, r) {
				t.push(n(r).data())
			}), t
		},
		collapse: function() {
			var t = this.options.cacheItems;
			this.$element.find(".fa.fa-folder-open").each(function() {
				var r = n(this).removeClass("fa fa-folder fa-folder-open").addClass("fa fa-folder"),
					u = r.parent().parent(),
					i = u.children(".tree-folder-content");
				i.hide();
				t || i.empty()
			})
		}
	};
	n.fn.tree = function(i, r) {
		var u, f = this.each(function() {
			var e = n(this),
				f = e.data("tree"),
				o = "object" == typeof i && i;
			f || e.data("tree", f = new t(this, o));
			"string" == typeof i && (u = f[i](r))
		});
		return void 0 === u ? f : u
	};
	n.fn.tree.defaults = {
		selectable: !0,
		multiSelect: !1,
		loadingHTML: "<div>Loading...<\/div>",
		cacheItems: !0
	};
	n.fn.tree.Constructor = t
}(window.jQuery);
/*
 * //# sourceMappingURL=tree-custom.min.js.map
 */