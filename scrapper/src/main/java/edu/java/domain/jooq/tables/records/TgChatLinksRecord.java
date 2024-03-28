/*
 * This file is generated by jOOQ.
 */
package edu.java.domain.jooq.tables.records;


import edu.java.domain.jooq.tables.TgChatLinks;

import java.beans.ConstructorProperties;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TgChatLinksRecord extends UpdatableRecordImpl<TgChatLinksRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>TG_CHAT_LINKS.ID</code>.
     */
    public void setId(@Nullable Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>TG_CHAT_LINKS.ID</code>.
     */
    @Nullable
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>TG_CHAT_LINKS.TG_CHAT_ID</code>.
     */
    public void setTgChatId(@NotNull Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>TG_CHAT_LINKS.TG_CHAT_ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getTgChatId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>TG_CHAT_LINKS.LINK_ID</code>.
     */
    public void setLinkId(@NotNull Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>TG_CHAT_LINKS.LINK_ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getLinkId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Long> field1() {
        return TgChatLinks.TG_CHAT_LINKS.ID;
    }

    @Override
    @NotNull
    public Field<Long> field2() {
        return TgChatLinks.TG_CHAT_LINKS.TG_CHAT_ID;
    }

    @Override
    @NotNull
    public Field<Long> field3() {
        return TgChatLinks.TG_CHAT_LINKS.LINK_ID;
    }

    @Override
    @Nullable
    public Long component1() {
        return getId();
    }

    @Override
    @NotNull
    public Long component2() {
        return getTgChatId();
    }

    @Override
    @NotNull
    public Long component3() {
        return getLinkId();
    }

    @Override
    @Nullable
    public Long value1() {
        return getId();
    }

    @Override
    @NotNull
    public Long value2() {
        return getTgChatId();
    }

    @Override
    @NotNull
    public Long value3() {
        return getLinkId();
    }

    @Override
    @NotNull
    public TgChatLinksRecord value1(@Nullable Long value) {
        setId(value);
        return this;
    }

    @Override
    @NotNull
    public TgChatLinksRecord value2(@NotNull Long value) {
        setTgChatId(value);
        return this;
    }

    @Override
    @NotNull
    public TgChatLinksRecord value3(@NotNull Long value) {
        setLinkId(value);
        return this;
    }

    @Override
    @NotNull
    public TgChatLinksRecord values(@Nullable Long value1, @NotNull Long value2, @NotNull Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TgChatLinksRecord
     */
    public TgChatLinksRecord() {
        super(TgChatLinks.TG_CHAT_LINKS);
    }

    /**
     * Create a detached, initialised TgChatLinksRecord
     */
    @ConstructorProperties({ "id", "tgChatId", "linkId" })
    public TgChatLinksRecord(@Nullable Long id, @NotNull Long tgChatId, @NotNull Long linkId) {
        super(TgChatLinks.TG_CHAT_LINKS);

        setId(id);
        setTgChatId(tgChatId);
        setLinkId(linkId);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised TgChatLinksRecord
     */
    public TgChatLinksRecord(edu.java.domain.jooq.tables.pojos.TgChatLinks value) {
        super(TgChatLinks.TG_CHAT_LINKS);

        if (value != null) {
            setId(value.getId());
            setTgChatId(value.getTgChatId());
            setLinkId(value.getLinkId());
            resetChangedOnNotNull();
        }
    }
}
