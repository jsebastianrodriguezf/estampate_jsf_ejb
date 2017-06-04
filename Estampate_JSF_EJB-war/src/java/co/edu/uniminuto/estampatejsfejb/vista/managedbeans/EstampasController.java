package co.edu.uniminuto.estampatejsfejb.vista.managedbeans;

import co.edu.uniminuto.estampatejsfejb.entitys.Colores;
import co.edu.uniminuto.estampatejsfejb.entitys.Estampas;
import co.edu.uniminuto.estampatejsfejb.entitys.Estilos;
import co.edu.uniminuto.estampatejsfejb.entitys.Tallas;
import co.edu.uniminuto.estampatejsfejb.session.ColoresFacade;
import co.edu.uniminuto.estampatejsfejb.vista.managedbeans.util.JsfUtil;
import co.edu.uniminuto.estampatejsfejb.vista.managedbeans.util.PaginationHelper;
import co.edu.uniminuto.estampatejsfejb.session.EstampasFacade;
import co.edu.uniminuto.estampatejsfejb.session.EstilosFacade;
import co.edu.uniminuto.estampatejsfejb.session.TallasFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "estampasController")
@SessionScoped
public class EstampasController implements Serializable {

    private Estampas current;
    private DataModel items = null;
    @EJB
    private co.edu.uniminuto.estampatejsfejb.session.EstampasFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    @EJB
    EstampasFacade EstampasFacade;
    @EJB
    ColoresFacade ColoresFacade;
    @EJB
    TallasFacade TallasFacade;
    @EJB
    EstilosFacade EstilosFacade;

    public EstampasController() {
    }

    public Estampas getSelected() {
        if (current == null) {
            current = new Estampas();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EstampasFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView(HttpServletRequest request) {
        current = (Estampas) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();

        HttpSession session = request.getSession();

        List<Colores> colores = ColoresFacade.findAll();
        List<Tallas> tallas = TallasFacade.findAll();
        List<Estilos> estilos = EstilosFacade.findAll();
        session.setAttribute("colores", colores);
        session.setAttribute("tallas", tallas);
        session.setAttribute("estilos", estilos);
        return "View";
    }

    public String prepareCreate() {
        current = new Estampas();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EstampasCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Estampas) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EstampasUpdated"));
            return "/estampas/List";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Estampas) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EstampasDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Estampas.class)
    public static class EstampasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstampasController controller = (EstampasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estampasController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Estampas) {
                Estampas o = (Estampas) object;
                return getStringKey(o.getIdestampa());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Estampas.class.getName());
            }
        }

    }

}
